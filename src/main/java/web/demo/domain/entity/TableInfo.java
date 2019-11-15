package web.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


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
    private String talName;
    private String description;
    @TableField(value = "user_fk")
    private Long userFk;

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
}
