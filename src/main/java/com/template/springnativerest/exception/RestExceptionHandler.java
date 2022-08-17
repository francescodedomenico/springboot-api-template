package com.template.springnativerest.exception;

import com.template.springnativerest.exception.throwables.BadRequestException;
import com.template.springnativerest.exception.throwables.ConflictException;
import com.template.springnativerest.exception.throwables.NotAuthorizedException;
import com.template.springnativerest.exception.utils.ExceptionHandlerUtils;

import lombok.Data;

import com.template.springnativerest.exception.responses.ApiResponse;
import com.template.springnativerest.exception.responses.Status;
import com.template.springnativerest.exception.responses.StatusCode;
import com.template.springnativerest.exception.responses.StatusType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * CustomResponseEntityExceptionHandler manages the validation on an argument annotated with @Valid
 * when it fails.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    static class ErrorResponse{
        StatusCode status;
        StatusType type;
    }

    private static final Logger log = LogManager.getLogger(RestExceptionHandler.class);
    @ExceptionHandler(value = {NotAuthorizedException.class})
    @SuppressWarnings("Duplicates")
    protected @ResponseBody ResponseEntity<Object> handleException(NotAuthorizedException ex) {
        log.error("Rest Exception has been thrown: ", ex.getMessage());
        return new ResponseEntity<>(ExceptionHandlerUtils.handleException(ex.getStatusCode(),
                ex.getStatusType(), ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value = {BadRequestException.class})
    @SuppressWarnings("Duplicates")
    @ResponseBody
    protected ResponseEntity<Object> handleException(BadRequestException ex, WebRequest request) {
        log.error("Rest Exception has been thrown: ", ex.getMessage());
        log.error("Rest Exception has been thrown: ", ex.getMessage());
        return new ResponseEntity<>(ExceptionHandlerUtils.handleException(ex.getStatusCode(),
                ex.getStatusType()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {ConflictException.class})
    @SuppressWarnings("Duplicates")
    protected @ResponseBody ResponseEntity<Object> handleException(ConflictException ex) {
        log.error("Rest Exception has been thrown: ", ex.getMessage());
        return new ResponseEntity<>(ExceptionHandlerUtils.handleException(ex.getStatusCode(),
                ex.getStatusType()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {Exception.class})
    @SuppressWarnings("Duplicates")
    protected @ResponseBody ResponseEntity<Object> handleGenericException(Exception ex) {
        log.error("Unexpected error occurred: ", ex);

        return new ResponseEntity<>(ExceptionHandlerUtils.handleException(
                StatusCode.HTTP_500,
                StatusType.INTERNAL_ERROR), HttpStatus.OK);
    }
}
