package web.demo.domain.vo;

import web.demo.domain.entity.TableInfo;

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

    public TblBasicVO(TableInfo tableInfo) {
        this.id = tableInfo.getId();
        this.createTime = tableInfo.getCreateTime();
        this.updateTime = tableInfo.getUpdateTime();
        this.tblName = tableInfo.getTblName();
        this.description = tableInfo.getDescription();
        this.userFk = tableInfo.getUserFk();
    }

    public Long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getTblName() {
        return tblName;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserFk() {
        return userFk;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
