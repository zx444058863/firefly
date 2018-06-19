package org.zealot.fireflybase.entity.permission;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.sql.Date;

/**
 * 组实体
 *
 * create by zhengxin 2018-6-11 14:33:30
 */
public class Group implements Serializable {

    /**
     * 主键
     */
    private Long id;

    private String indexCode;

    private String groupName;

    private String parentIndex;

    private String description;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Group() {
    }

    public Group(Long id, String indexCode, String groupName, String parentIndex, String description,
                 Date createTime) {
        this.id = id;
        this.indexCode = indexCode;
        this.groupName = groupName;
        this.parentIndex = parentIndex;
        this.description = description;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(String parentIndex) {
        this.parentIndex = parentIndex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
