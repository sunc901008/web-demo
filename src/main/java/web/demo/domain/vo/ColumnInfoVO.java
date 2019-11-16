package web.demo.domain.vo;

import com.baomidou.mybatisplus.annotation.*;
import web.demo.base.NotBlank;
import web.demo.base.Size;
import web.demo.domain.entity.ColumnInfo;

import java.util.Date;

/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

public class ColumnInfoVO extends BaseValueObject {
    private Long id;
    private String colName;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
