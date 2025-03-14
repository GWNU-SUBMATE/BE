package com.submate.common.ui;

import com.submate.common.domain.exception.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ErrorDetails> handleIllegalArgumentException() {
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST).
                body(new ErrorDetails("잘못된 입력입니다."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException() {
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST).
                body(new ErrorDetails("잘못된 요청입니다. 관리자에게 문의해주세요."));
    }
}
