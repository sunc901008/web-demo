package web.demo.domain.repository;

import web.demo.domain.entity.ColumnInfo;

import java.util.List;


/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

public interface ColumnInfoRepo {

    /**
     * 批量插入
     *
     * @param columns columns
     */
    void inserts(List<ColumnInfo> columns);

    /**
     * 插入
     *
     * @param column column
     */
    void insert(ColumnInfo column);

}
