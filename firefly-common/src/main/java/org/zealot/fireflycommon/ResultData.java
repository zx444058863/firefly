package org.zealot.fireflycommon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zealot.fireflycommon.enumerate.ErrorCode;

import java.io.Serializable;

/**
 * Restful接口返回数据统一处理
 *
 * create by zhengxin @2018-6-19 11:14:00
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultData implements Serializable {

    /**
     * 返回码，非0即失败
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public static ResultData success() {
        return success(null);
    }

    public static ResultData success(Object data) {
        return new ResultData(
                ErrorCode.SUCCESS.getCode(),
                ErrorCode.SUCCESS.getDescription(),
                data);
    }

    public static ResultData failed(ErrorCode errorCode) {
        return failed(errorCode, null);
    }

    public static ResultData failed(ErrorCode errorCode, Object data) {
        return failed(errorCode.getCode(), errorCode.getDescription(), data);
    }

    public static ResultData failed(String code, String message) {
        return failed(code, message, null);
    }

    public static ResultData failed(String code, String message, Object data) {
        return new ResultData(code, message, data);
    }
}
