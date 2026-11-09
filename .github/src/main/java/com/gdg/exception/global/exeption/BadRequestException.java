package com.gdg.exception.global.exeption;

public class BadRequestException extends CustomException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
