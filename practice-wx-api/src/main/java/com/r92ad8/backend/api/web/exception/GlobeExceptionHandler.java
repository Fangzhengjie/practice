package com.r92ad8.backend.api.web.exception;

import com.r92ad8.core.entity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author fangzhengjie
 * @date 2019-01-15
 */
@Slf4j
@RestControllerAdvice
public class GlobeExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        log.error("", e);
        return ResponseEntity.failure();
    }
}
