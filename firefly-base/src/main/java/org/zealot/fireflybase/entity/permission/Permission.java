package org.zealot.fireflybase.entity.permission;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 权限实体
 *
 * create by zhengxin 2018-6-11 14:36:53
 */
@Entity
@Table(name = "t_permission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "indexCode", nullable = false, length = 64)
    private String indexCode;

    /**
     * 权限字符串
     * <p>menu例子：role:*，button例子：role:create,role:update,role:delete,role:view</p>
     */
    @Column(name = "permissionName", nullable = false, length = 64)
    private String permissionName;

    /**
     * 资源类型，[menu|button]
     */
    @Column(name = "resourceType", columnDefinition = "enum('menu','button')")
    private String resourceType;

    /**
     * 资源路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 父权限编码
     */
    @Column(name = "parentIndex", length = 64)
    private String parentIndex;
//    private String parentIds; // 父编号列表

    @Column(name = "available")
    private Boolean available = Boolean.FALSE;

    @Column(name = "description")
    private String description;

    @CreatedDate
    @Column(name = "createTime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 角色-权限多对多关系
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission_mapping", joinColumns = {@JoinColumn(name = "permissionIndex", referencedColumnName = "indexCode")},
        inverseJoinColumns = {@JoinColumn(name = "roleIndex", referencedColumnName = "indexCode")})
    private List<Role> roleList;

}
