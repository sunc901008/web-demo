package web.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import web.demo.base.Constant;
import web.demo.mapper.SchemaMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 初始化, 项目启动后执行
 *
 * @author sunc
 * @date 2019/11/11 8:34
 * @description ApplicationRunnerImpl
 */

//@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Resource
    private SchemaMapper schemaMapper;

    @Override
    public void run(ApplicationArguments args) {
        List<String> tables = schemaMapper.getTableWithTenantFk();
        Constant.HAS_TENANT_TABLES.addAll(tables);
    }
}
