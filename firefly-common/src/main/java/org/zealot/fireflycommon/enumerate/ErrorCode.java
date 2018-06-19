package org.zealot.fireflycommon.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 错误码
 *
 * create by zhengxin @2018-6-19 13:57:40
 */
@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS("0", "操作成功"),
    UNKNOWN_ERROR("-1", "未知错误"),
    //100001~100199 系统错误
    STACK_OVER_FLOW("100001", "堆栈溢出"),
    IO_EXCEPTION("100002", "IO错误"),
    HTTP_400("100003", "HTTP 400"),
    HTTP_404("100004", "HTTP 404"),
    //100001~100200 用户操作错误
    SIGN_UP_FAILED("100201", "注册失败"),
    USER_IS_EXIST("100202", "账号已存在")
    ;


    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String description;
}
