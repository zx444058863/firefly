package org.zealot.fireflybase.entity.permission;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 角色实体类
 *
 * create by zhengxin 2018-6-11 14:13:24
 */
@Entity
@Table(name = "t_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "indexCode", nullable = false, length = 64)
    private String indexCode;

    @Column(name = "roleName", nullable = false, length = 64)
    private String roleName;

    /**
     * 父角色indexCode
     */
    @Column(name = "parentIndex", length = 64)
    private String parentIndex;

    /**
     * 角色描述
     */
    @Column(name = "description")
    private String description;

    @CreatedDate
    @Column(name = "createTime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 角色-用户多对多关系
     */
    @ManyToMany
    @JoinTable(name = "user_role_mapping", joinColumns = {@JoinColumn(name = "roleIndex", referencedColumnName = "indexCode")},
        inverseJoinColumns = {@JoinColumn(name = "userIndex", referencedColumnName = "indexCode")})
    private List<User> userList;

    /**
     * 角色-权限多对多关系
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission_mapping", joinColumns = {@JoinColumn(name = "roleIndex", referencedColumnName = "indexCode")},
        inverseJoinColumns = {@JoinColumn(name = "permissionIndex", referencedColumnName = "indexCode")})
    private List<Permission> permissionList;

}
