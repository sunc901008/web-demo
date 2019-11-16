package web.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import web.demo.domain.vo.ColumnInfoVO;


/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

@Data
@TableName("table_info")
public class ColumnInfo extends BaseEntity {

    @TableField("col_name")
    private String colName;
    @TableField(value = "table_fk")
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

    public ColumnInfoVO columnInfoVO() {
        ColumnInfoVO columnInfoVO = new ColumnInfoVO();
        columnInfoVO.setId(this.getId());
        columnInfoVO.setCreateTime(this.getCreateTime());
        columnInfoVO.setUpdateTime(this.getUpdateTime());
        columnInfoVO.setColName(this.getColName());
        return columnInfoVO;
    }

}
