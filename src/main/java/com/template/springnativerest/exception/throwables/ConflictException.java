package com.template.springnativerest.exception.throwables;

import com.template.springnativerest.exception.responses.StatusCode;
import com.template.springnativerest.exception.responses.StatusType;

public class ConflictException extends RuntimeException {

    protected StatusCode statusCode;
    protected StatusType statusType;

    public ConflictException(StatusCode statusCode) {
        super(statusCode.getDescription());
        this.statusCode = statusCode;
        this.statusType = StatusType.ERROR;
    }

    public ConflictException(StatusCode statusCode, StatusType statusType) {
        super(statusCode.getDescription());
        this.statusCode = statusCode;
        this.statusType = statusType;
    }

    public ConflictException(StatusCode statusCode, Throwable cause) {
        super(statusCode.getDescription(), cause);
        this.statusCode = statusCode;
        this.statusType = StatusType.ERROR;
    }

    public ConflictException(StatusCode statusCode, StatusType statusType, Throwable cause) {
        super(statusCode.getDescription(), cause);
        this.statusCode = statusCode;
        this.statusType = statusType;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public StatusType getStatusType() {
        return statusType;
    }
}
