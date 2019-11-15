package web.demo.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/11 8:34
 * @description Constant
 */

public class Constant {

    /**
     * 多租户外键
     */
    public static final String SYSTEM_TENANT_FK = "tenant_fk";
    /**
     * 含有多租户字段的表(需要自动添加多租户条件), 项目启动时初始化。
     */
    public static List<String> HAS_TENANT_TABLES = new ArrayList<>();

    /**
     * 初始化获取含有 tenant_fk 列的表名的sql
     */
    public static final String SCHEMA_SQL = "SELECT table_name FROM information_schema.columns WHERE table_schema = (SELECT database" +
            "()) AND column_name = 'tenant_fk'";

}
