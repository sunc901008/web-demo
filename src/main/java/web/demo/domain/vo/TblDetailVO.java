package web.demo.domain.vo;

import web.demo.domain.entity.ColumnInfo;
import web.demo.domain.entity.TableInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * table info detail
 *
 * @author sunc
 * @date 2019/11/15 18:07
 * @description TblDetailVO
 */

public class TblDetailVO extends TblBasicVO {

    private List<ColumnInfoVO> columns;

    public TblDetailVO(TableInfo tableInfo, List<ColumnInfo> columns) {
        super(tableInfo);
        List<ColumnInfoVO> cols = new ArrayList<>();
        columns.forEach(col -> cols.add(col.columnInfoVO()));
        this.columns = cols;
    }

    public List<ColumnInfoVO> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
