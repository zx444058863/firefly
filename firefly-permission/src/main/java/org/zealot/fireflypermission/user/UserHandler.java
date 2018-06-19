package org.zealot.fireflypermission.user;

import org.zealot.fireflybase.entity.permission.User;

import java.util.List;

public interface UserHandler {

    static final int HASH_ITERATIONS = 3;  //加密次数

    /**
     * 创建单个用户（注册）
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     * 根据indexCode删除用户
     * @param indexCode
     * @return 0:删除失败；1：删除成功
     */
    int deleteUserByIndexCode(String indexCode);

    /**
     * 删除组织下的所有用户(不递归)
     * @param orgIndex
     */
    void deleteUserByOrgIndex(String orgIndex);

    /**
     * 删除用户组里的所有用户(不递归)
     * @param groupIndex
     */
    void deleteUserByGroupIndex(String groupIndex);

    /**
     * 删除所有用户
     */
    void deleteAllUser();

    /**
     * 根据indexCode更新用户基本信息
     * @param user
     * @return
     */
    int updateUserBaseInfoByIndexCode(User user);

    /**
     * 根据indexCode查询用户
     * @param indexCode
     * @return
     */
    User findUserByIndexCode(String indexCode);

    /**
     * 查询用户组中所有用户
     * @param groupIndex
     * @return
     */
    List<User> findUserByGroupIndex(String groupIndex);

    /**
     * 查询组织下所有用户(不递归)
     * @param orgIndex
     * @return
     */
    List<User> findUserByOrgIndex(String orgIndex);

    /**
     * 根据账号查找用户
     * @param loginName
     * @return
     */
    User findUserByLoginName(String loginName);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();

}
