package web.demo.domain.dto;

import web.demo.base.NotBlank;
import web.demo.base.Size;
import web.demo.domain.entity.ColumnInfo;

/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

public class ColumnInfoParam extends BaseValueObject {

    @Size(max = 20, min = 6, message = "name length illegal", errCode = 10001)
    @NotBlank
    private String colName;
    private Long tableFk;

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public Long getTableFk() {
        return tableFk;
    }

    public void setTableFk(Long tableFk) {
        this.tableFk = tableFk;
    }

    public ColumnInfo getColumn(Long tableFk) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColName(this.colName);
        columnInfo.setTableFk(tableFk);
        return columnInfo;
    }
}
