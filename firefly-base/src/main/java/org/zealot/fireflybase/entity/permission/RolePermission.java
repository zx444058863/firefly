package org.zealot.fireflybase.entity.permission;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 映射权限-角色中间表
 *
 * create by zhengxin @2018-6-11 16:23:28
 */
@Entity
@Table(name = "role_permission_mapping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "permissionIndex", nullable = false, length = 64)
    private String permissionIndex;

    @Column(name = "roleIndex", nullable = false, length = 64)
    private String roleIndex;

    @CreatedDate
    @Column(name = "createTime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
