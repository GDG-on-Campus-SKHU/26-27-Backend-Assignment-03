package com.gdg.exception.global.exception;

public class NotSupportException extends CustomException {
    public NotSupportException(ErrorCode errorCode) {
        super(errorCode);
    }
}
