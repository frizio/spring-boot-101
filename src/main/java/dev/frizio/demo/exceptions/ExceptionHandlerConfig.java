package dev.frizio.demo.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerConfig {

    //handle the Exceptions as you want
    @ExceptionHandler(WebExchangeBindException.class)
    public void handleException(WebExchangeBindException e) {
        log.error("Error Validation", e);
        throw e;
    }

}
