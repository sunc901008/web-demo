package web.demo.domain.dto;

import web.demo.base.NotBlank;
import web.demo.base.NotNull;
import web.demo.base.Size;
import web.demo.domain.entity.ColumnInfo;
import web.demo.domain.entity.TableInfo;
import web.demo.exception.BaseException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:07
 * @description TableInfoParam
 */

public class TableInfoParam extends BaseValueObject<TableInfoParam> {
    private Long fk;
    @Size(max = 20, min = 6, message = "name length illegal", errCode = 10001)
    @NotBlank
    private String talName;
    private String description;
    private Long userFk;
    @NotNull
    private List<ColumnInfoParam> columns;

    public Long getFk() {
        return fk;
    }

    public void setFk(Long fk) {
        this.fk = fk;
    }

    public String getTalName() {
        return talName;
    }

    public void setTalName(String talName) {
        this.talName = talName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserFk() {
        return userFk;
    }

    public void setUserFk(Long userFk) {
        this.userFk = userFk;
    }

    public List<ColumnInfoParam> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnInfoParam> columns) {
        this.columns = columns;
    }

    public static TableInfoParam init(String text) throws BaseException {
        return new TableInfoParam().init(text, TableInfoParam.class);
    }

//    @Override
//    public void valid() throws BaseException {
//        throw new BaseException(9999, "test");
//    }

    public TableInfo getTable() {
        TableInfo tableInfo = new TableInfo();
        tableInfo.setDescription(this.description);
        tableInfo.setTalName(this.talName);
        return tableInfo;
    }

    public List<ColumnInfo> getColumns(Long tblFk) {
        List<ColumnInfo> columns = new ArrayList<>();
        this.columns.forEach(col -> columns.add(col.getColumn(tblFk)));
        return columns;
    }

}
