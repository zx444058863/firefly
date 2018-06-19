package org.zealot.fireflypermission.role;

import org.zealot.fireflybase.entity.permission.Role;

import java.util.List;

/**
 * 角色操作
 *
 * create by zhengxin @2018-6-13 17:38:13
 */
public interface RoleHandler {

    /**
     * 添加一个角色
     * @param role
     * @return
     */
    Role createRole(Role role);

    /**
     * 根据indexCode删除角色
     * @param indexCode
     * @return
     */
    void deleteRoleByIndexCode(String indexCode);

    /**
     * 批量删除角色
     * @param roleList
     * @return
     */
    void deleteAllRole(List<Role> roleList);

    /**
     * 根据indexCode查询单个角色
     * @param indexCode
     * @return
     */
    Role findRoleByIndexCode(String indexCode);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAllRole();

}
