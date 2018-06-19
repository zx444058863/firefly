package org.zealot.fireflycommon.exception.bussiness;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zealot.fireflycommon.enumerate.ErrorCode;

@Getter
@Setter
@NoArgsConstructor
public class UserException extends RuntimeException {

    private String code;

    private String message;

    public UserException(String code, String message) {
        super(message);
        this.code = code;
    }

    public UserException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getDescription();
    }
}
