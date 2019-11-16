package web.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import web.demo.domain.vo.TblBasicVO;
import web.demo.domain.vo.TblDetailVO;

import java.util.Date;


/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

@Data
@TableName("table_info")
public class TableInfo extends BaseEntity {

    @TableField(fill = FieldFill.INSERT)
    private Long fk;
    @TableField("tbl_name")
    private String tblName;
    private String description;
    @TableField(value = "user_fk")
    private Long userFk;

    public Long getFk() {
        return fk;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
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

    public TblBasicVO tblBasicVO() {
        return tblDetailVO();
    }

    public TblDetailVO tblDetailVO() {
        TblDetailVO tblBasicVO = new TblDetailVO();
        tblBasicVO.setId(this.getId());
        tblBasicVO.setCreateTime(this.getCreateTime());
        tblBasicVO.setUpdateTime(this.getUpdateTime());
        tblBasicVO.setTblName(this.getTblName());
        tblBasicVO.setDescription(this.getDescription());
        tblBasicVO.setUserFk(this.getUserFk());
        return tblBasicVO;
    }

}

