package web.demo.domain.vo;

import web.demo.domain.entity.ColumnInfo;

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

    public List<ColumnInfoVO> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnInfoVO> columns) {
        this.columns = columns;
    }

    public void addColumnVO(ColumnInfoVO columnInfoVO) {
        if (this.columns == null) {
            this.columns = new ArrayList<>();
        }
        this.columns.add(columnInfoVO);
    }

}
