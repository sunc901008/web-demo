package web.demo.domain.repository;

import web.demo.domain.entity.TableInfo;

/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

public interface TableInfoRepo {

    /**
     * 保存表
     *
     * @param tableInfo table
     * @return 保存之后的table
     */
    TableInfo insert(TableInfo tableInfo);

}
