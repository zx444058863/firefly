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
 * 用户实体类
 *
 * create by zhengxin 2018-6-11 14:06:49
 */
@Entity
@Table(name = "t_user")
//@NamedQueries({
//        @NamedQuery(name="findUserByIndex",query="SELECT u FROM User u WHERE u.name = :name")
//
//})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "indexCode", nullable = false, length = 64, unique = true)
    private String indexCode;

    @Column(name = "userName", nullable = false, length = 64)
    private String userName;

    @Column(name = "loginName", nullable = false, length = 64, unique = true)
    private String loginName;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    /**
     * 加密密码的盐值
     */
    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "groupIndex", length = 64)
    private String groupIndex;

    @Column(name = "mobile", length = 64)
    private String mobile;

    @Column(name = "email", length = 64)
    private String email;

    /**
     * 用户状态
     * <p>0：创建未验证；1：正常状态；2：用户被锁定</p>
     */
    @Column(name = "status", nullable = false, length = 4)
    private byte status;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "loginTime")
    private Date loginTime;

    @Column(name = "lastLoginTime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    @Column(name = "createTime")
    @CreatedDate
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 多对多关联， 一个用户具有多个角色
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role_mapping", joinColumns = { @JoinColumn(name = "userIndex", referencedColumnName = "indexCode")},
            inverseJoinColumns = {@JoinColumn(name = "roleIndex", referencedColumnName = "indexCode")})
    private List<Role> roleList;


    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.loginName + this.salt;
    }
}
