package web.demo.domain.vo;

import java.util.Date;

/**
 * table basic info
 *
 * @author sunc
 * @date 2019/11/15 18:07
 * @description TblBasicVO
 */

public class TblBasicVO extends BaseValueObject {

    private Long id;
    private Date createTime;
    private Date updateTime;
    private String tblName;
    private String description;
    private Long userFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
