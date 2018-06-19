package org.zealot.fireflydao.repository.permission;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.zealot.fireflybase.entity.permission.User;

import javax.transaction.Transactional;

/**
 * 自定义的spring-data-jpa的Repository接口，能对User进行基本的crud操作
 * <p>添加自定义JPQL查询接口</p>
 *
 * create by zhengxin @2018-6-14 15:17:47
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {

    /**
     * 根据indexCode查询User信息
     * @param indexCode
     * @return
     */
    User findUserByIndexCode(String indexCode);

    /**
     * 根据登录账号查询用户信息
     * @param loginName
     * @return
     */
    User findUserByLoginName(String loginName);

    /**
     * 根据登录名查询用户信息
     * <p>注册时用，保证登录账号唯一</p>
     * @param loginName
     * @return
     */
    Boolean existsUserByLoginName(String loginName);

    /**
     * 根据indexCode删除用户信息
     * @param indexCode
     * @return
     */
    void deleteUserByIndexCode(String indexCode);

    /**
     * 根据indexCode更新User基本信息
     * @param userName
     * @param mobile
     * @param email
     * @param indexCode
     * @return
     */
    @Transactional
    @Modifying
    @Query("update User as u set u.userName=:userName, u.mobile=:mobile," +
            "u.email=:email where u.indexCode=:indexCode")
    int updateUserBaseInfoByIndexCode(@Param("userName") String userName, @Param("mobile") String mobile,
                                      @Param("email") String email, @Param("indexCode") String indexCode);

    /**
     * 修改用户密码
     * @param newPwd
     * @param indexCode
     * @return
     */
    @Transactional
    @Modifying
    @Query("update User as u set u.password=:newPwd where u.indexCode=:indexCode")
    int updateUserPasswordByIndexCode(@Param("newPwd") String newPwd, @Param("indexCode") String indexCode);

}
