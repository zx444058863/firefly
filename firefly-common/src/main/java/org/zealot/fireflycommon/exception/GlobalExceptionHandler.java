package org.zealot.fireflycommon.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.zealot.fireflycommon.ResultData;
import org.zealot.fireflycommon.exception.bussiness.UserException;

/**
 * 异常拦截处理器
 *
 * create by zhengxin @2018-6-19 11:09:55
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String LOG_EXCEPTION_FORMAT = "Capture Exception By GlobalExceptionHandler: Code: %s" +
            " Detail: %s";

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


//    /**
//     * RuntimeException --> 未知错误
//      * @param ex
//     * @return
//     */
//    @ExceptionHandler(RuntimeException.class)
//    public ResultData runtimeExceptionHandler(RuntimeException ex) {
//        return resultFormat(ErrorCode.UNKNOWN_ERROR, ex);
//    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(value = UserException.class)
    public ResultData userExceptionHandler(UserException e) {
        return ResultData.failed(e.getCode(), e.getMessage());
    }

//    private <T extends Throwable> ResultData resultFormat(ErrorCode errorCode, T ex) {
//        ex.printStackTrace();
//        logger.error(String.format(LOG_EXCEPTION_FORMAT, errorCode, ex.getMessage()));
//        return ResultData.failed(errorCode);
//    }

}
