package web.demo.config.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import web.demo.config.TenantContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author sunc
 * @date 2019/11/10 18:04
 * @description d
 */

@Component
public class TenantHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(TenantHandlerInterceptor.class);

    private final TenantContext tenantContext;

    @Autowired
    public TenantHandlerInterceptor(TenantContext tenantContext) {
        this.tenantContext = tenantContext;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String flag = UUID.randomUUID().toString();
        request.setAttribute("flag", flag);
        String uri = request.getRequestURI();
        String requestMethod = request.getMethod();
        logger.info(String.format("Flag:%s. Received request. Path:%s. Method:%s.", flag, uri, requestMethod));
        String tenantFk = uri.substring(uri.indexOf("/") + 1);
        tenantFk = tenantFk.substring(0, tenantFk.indexOf("/"));
        tenantContext.setCurrentTenantId(Long.parseLong(tenantFk));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex != null) {
            logger.error(ex.getMessage());
        }
        tenantContext.remove();
        String flag = request.getAttribute("flag").toString();
        logger.info(String.format("Flag:%s.Response request.", flag));
    }

}
