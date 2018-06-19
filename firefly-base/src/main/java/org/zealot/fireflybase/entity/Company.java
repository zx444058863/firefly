package org.zealot.fireflybase.entity;

import java.io.Serializable;

/**
 * Company entity
 *
 * create by zhengxin 2018-6-11 14:39:40
 */
public class Company implements Serializable {

    private Long id;

    private String companyName;

    private String indexCode;

    // TODO: 2018/6/11 下属组织集合或者组织树


    public Company() {
    }

    public Company(Long id, String companyName, String indexCode) {
        this.id = id;
        this.companyName = companyName;
        this.indexCode = indexCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }
}
