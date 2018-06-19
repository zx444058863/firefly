package org.zealot.fireflyweb.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.zealot.fireflybase.entity.permission.User;
import org.zealot.fireflycommon.ResultData;
import org.zealot.fireflycommon.enumerate.ErrorCode;
import org.zealot.fireflycommon.exception.bussiness.UserException;
import org.zealot.fireflydao.repository.permission.UserCrudRepository;
import org.zealot.fireflypermission.user.UserHandler;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/crud")
public class TestCrudController {

    @Resource
    private UserHandler userHandler;

    /**
     * 用户注册测试
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ResultData signUpUser(@RequestBody User user) throws UserException {
        User insertRes = userHandler.createUser(user);
        if (insertRes != null) {
            return ResultData.success(insertRes);
        }
        return ResultData.failed(ErrorCode.UNKNOWN_ERROR);
    }

    /**
     * 用户查询测试
     * @param indexCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResultData findUserByIndexCode(@RequestParam String indexCode){
        User user = userHandler.findUserByIndexCode(indexCode);
        return ResultData.success(user);
    }

    /**
     * 用户修改测试
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public Map<String, Object> testUpdateUser(@RequestBody User user) {
        int result = userHandler.updateUserBaseInfoByIndexCode(user);
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        return map;
    }
}
