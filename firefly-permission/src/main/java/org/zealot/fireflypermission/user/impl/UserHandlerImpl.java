package org.zealot.fireflypermission.user.impl;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zealot.fireflybase.entity.permission.User;
import org.zealot.fireflycommon.enumerate.ErrorCode;
import org.zealot.fireflycommon.exception.bussiness.UserException;
import org.zealot.fireflycommon.utils.UUIDUtil;
import org.zealot.fireflydao.repository.permission.UserCrudRepository;
import org.zealot.fireflypermission.user.UserHandler;

import java.util.List;

@Service(value = "userHandler")
public class UserHandlerImpl implements UserHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserHandlerImpl.class);

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public User createUser(User user) {
        //1.校验账号重复否
        String loginName = user.getLoginName();
        if (userCrudRepository.existsUserByLoginName(loginName)) {
            throw new UserException(ErrorCode.USER_IS_EXIST);
        }
        try {
            //2.为User打上indexCode TODO:后续需要专门写一个生成indexCode的包
            user.setIndexCode(UUIDUtil.getIndexCode());
            //3.密码加密
            String cipherPlaintext = user.getPassword();
            //生成盐（部分，需要存入数据库中）
            String random = new SecureRandomNumberGenerator().nextBytes().toHex();
            String cipherText = new Md5Hash(cipherPlaintext, random, HASH_ITERATIONS).toString();
            user.setSalt(random);
            user.setPassword(cipherText);
            return userCrudRepository.save(user);
        } catch (Exception e) {
            logger.error("Insert user got an exception:", e);
        }
        return null;
    }

    @Override
    public int deleteUserByIndexCode(String indexCode) {
        try {
            userCrudRepository.deleteUserByIndexCode(indexCode);
            return 1;
        } catch (Exception e) {
            logger.error("Delete user by indexCode got an exception:", e);
        }
        return 0;
    }

    @Override
    public void deleteUserByOrgIndex(String orgIndex) {

    }

    @Override
    public void deleteUserByGroupIndex(String groupIndex) {

    }

    @Override
    public void deleteAllUser() {

    }

    @Override
    public int updateUserBaseInfoByIndexCode(User user) {
        try {
            return userCrudRepository.updateUserBaseInfoByIndexCode(user.getUserName(), user.getMobile(),
                    user.getEmail(), user.getIndexCode());
        } catch (Exception e) {
            logger.error("Update user base info by indexCode got an exception:", e);
        }
        return 0;
    }

    @Override
    public User findUserByIndexCode(String indexCode) {
        try {
            return userCrudRepository.findUserByIndexCode(indexCode);
        } catch (Exception e) {
            logger.error("Find user by indexCode got an exception:", e);
        }
        return null;
    }

    @Override
    public List<User> findUserByGroupIndex(String groupIndex) {
        return null;
    }

    @Override
    public List<User> findUserByOrgIndex(String orgIndex) {
        return null;
    }

    @Override
    public User findUserByLoginName(String loginName) {
        try {
            return userCrudRepository.findUserByLoginName(loginName);
        } catch (Exception e) {
            logger.error("Find user by login name got an exception: ", e);
        }
        return null;
    }

    @Override
    public List<User> findAllUser() {
        try {
            return (List<User>) userCrudRepository.findAll();
        } catch (Exception e) {
            logger.error("Find all user got an exception:", e);
        }
        return null;
    }
}
