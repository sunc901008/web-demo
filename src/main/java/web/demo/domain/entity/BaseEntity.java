package web.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import web.demo.base.Commons;

import java.util.Date;

/**
 * @author sunc
 * @date 2019/11/15 17:56
 * @description BaseEntity
 */

@Data
public abstract class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;
    @Version
    private Long version;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String toJsonString() {
        return Commons.toJsonString(this);
    }

}
