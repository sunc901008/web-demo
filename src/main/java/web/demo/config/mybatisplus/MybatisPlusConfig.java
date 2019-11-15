package web.demo.config.mybatisplus;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.demo.base.Constant;
import web.demo.config.TenantContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miemie
 * @since 2018-08-10
 */
@Configuration
@MapperScan(basePackages = {"web.demo.mapper"})
public class MybatisPlusConfig {

    private final TenantContext tenantContext;

    @Autowired
    public MybatisPlusConfig(TenantContext tenantContext) {
        this.tenantContext = tenantContext;
    }

    /**
     * 乐观锁
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 多租户属于 SQL 解析部分，依赖 MP 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser().setTenantHandler(new TenantHandler() {

            @Override
            public Expression getTenantId(boolean where) {
                Long tenantId = tenantContext.getCurrentTenantId();
                return new LongValue(tenantId);
            }

            @Override
            public String getTenantIdColumn() {
                return Constant.SYSTEM_TENANT_FK;
            }

            @Override
            public boolean doTableFilter(String tableName) {
                // 这里可以判断是否过滤表
                return !Constant.HAS_TENANT_TABLES.contains(tableName);
            }

        });

        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

//    /***
//     * plus 的性能优化
//     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        /* <!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 --> */
//        //performanceInterceptor.setMaxTime(1000);
//        /* <!--SQL是否格式化 默认false--> */
//        performanceInterceptor.setFormat(false);
//        return performanceInterceptor;
//    }

}
