package web.demo.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunc
 * @date 2019/11/10 19:57
 * @description WebConfigurer
 */

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    private final TenantHandlerInterceptor tenantHandlerInterceptor;

    @Autowired
    public WebConfigurer(TenantHandlerInterceptor tenantHandlerInterceptor) {
        this.tenantHandlerInterceptor = tenantHandlerInterceptor;
    }

    /**
     * 配置静态资源, 如 html,js,css
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantHandlerInterceptor).addPathPatterns("/**");
    }
}