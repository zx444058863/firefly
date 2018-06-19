package org.zealot.fireflybase.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.zealot.fireflybase.entity.permission.User;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Organization entity.
 *
 * create by zhengxin 2018-6-11 14:47:35
 */
public class Organization implements Serializable {

    private Long id;

    private String indexCode;

    private String orgName;

    private Company company;

    private String description;

    private List<User> users;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Organization() {
    }

    public Organization(Long id, String indexCode, String orgName, Company company, String description, List<User> users, Date createTime, Date updateTime) {
        this.id = id;
        this.indexCode = indexCode;
        this.orgName = orgName;
        this.company = company;
        this.description = description;
        this.users = users;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
