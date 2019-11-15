package web.demo.config;

import org.springframework.stereotype.Component;

/**
 * @author sunc
 * @date 2019/10/25 9:56
 * @description TenantContext
 */

@Component
public class TenantContext {

    /**
     * ThreadLocal 并发
     */
    private ThreadLocal<Long> tenantFk = new ThreadLocal<>();

    public Long getCurrentTenantId() {
        Long fk = tenantFk.get();
        if (fk == null) {
            return -1L;
        }
        return fk;
    }

    public void remove() {
        tenantFk.remove();
    }

    public void setCurrentTenantId(Long tenantId) {
        this.tenantFk.set(tenantId);
    }
}