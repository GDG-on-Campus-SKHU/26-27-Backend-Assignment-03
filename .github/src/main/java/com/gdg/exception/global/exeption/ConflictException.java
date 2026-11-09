package com.gdg.exception.global.exeption;

public class ConflictException extends CustomException {

    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}
