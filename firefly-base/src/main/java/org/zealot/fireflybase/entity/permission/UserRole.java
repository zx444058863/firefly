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
 * 映射角色-用户中间表
 *
 * create by zhengxin @2018-6-11 16:12:56
 */
@Entity
@Table(name = "user_role_mapping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "userIndex", nullable = false, length = 64)
    private String userIndex;

    @Column(name = "roleIndex", nullable = false, length = 64)
    private String roleIndex;

    @CreatedDate
    @Column(name = "createTime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
