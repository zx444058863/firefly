package org.zealot.fireflydao.repository.permission;

import org.springframework.data.repository.CrudRepository;
import org.zealot.fireflybase.entity.permission.Role;

/**
 * 自定义的spring-data-jpa的Repository接口，能对User进行基本的crud操作
 * <p>添加自定义JPQL查询接口</p>
 *
 * create by zhengxin @22018-6-15 14:44:16
 */
public interface RoleCrudRepository extends CrudRepository<Role, Long> {

    /**
     * 根据indexCode查询角色
     * @param indexCode
     * @return
     */
    Role findRoleByIndexCode(String indexCode);

    /**
     * 根据indexCode删除角色
     * @param indexCode
     */
    void deleteRoleByIndexCode(String indexCode);

}
