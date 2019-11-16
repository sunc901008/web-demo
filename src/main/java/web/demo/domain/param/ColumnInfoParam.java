package web.demo.domain.param;

import web.demo.base.NotBlank;
import web.demo.base.Size;
import web.demo.domain.entity.ColumnInfo;
import web.demo.exception.ExceptionCode;

/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

public class ColumnInfoParam extends BaseParamObject {

    @Size(max = 20, min = 6, message = "name length illegal", errCode = ExceptionCode.NAME_LENGTH_ERROR)
    @NotBlank
    private String colName;

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public ColumnInfo getColumn(Long tableFk) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColName(this.colName);
        columnInfo.setTblFk(tableFk);
        return columnInfo;
    }
}
