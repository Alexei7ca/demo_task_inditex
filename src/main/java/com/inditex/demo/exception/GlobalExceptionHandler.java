package com.inditex.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String throwResourceNotFoundException(NotFoundException notFoundException) {
        log.error("NotFoundException Thrown ", notFoundException);
        return notFoundException.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String throwMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error("MethodArgumentNotValidException Thrown ", methodArgumentNotValidException);
        return methodArgumentNotValidException.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String throwIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        log.error("IllegalArgumentException Thrown ", illegalArgumentException);
        return illegalArgumentException.getMessage();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String throwMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
        log.error("MethodArgumentTypeMismatchException Thrown ", methodArgumentTypeMismatchException);
        return methodArgumentTypeMismatchException.getMessage();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String throwMissingServletRequestParameterException(MissingServletRequestParameterException missingServletRequestParameterException) {
        log.error("MissingServletRequestParameterException Thrown ", missingServletRequestParameterException);
        return missingServletRequestParameterException.getMessage();
    }

}