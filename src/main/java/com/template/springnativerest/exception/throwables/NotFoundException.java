package com.template.springnativerest.exception.throwables;

import com.template.springnativerest.exception.responses.StatusCode;
import com.template.springnativerest.exception.responses.StatusType;

public class NotFoundException extends RuntimeException {

    protected StatusCode statusCode;
    protected StatusType statusType;

    public NotFoundException(StatusCode statusCode) {
        super(statusCode.getDescription());
        this.statusCode = statusCode;
        this.statusType = StatusType.ERROR;
    }

    public NotFoundException(StatusCode statusCode, StatusType statusType) {
        super(statusCode.getDescription());
        this.statusCode = statusCode;
        this.statusType = statusType;
    }
    
    public NotFoundException(StatusCode statusCode, StatusType statusType, String description) {
        super(description);
        this.statusCode = statusCode;
        this.statusType = statusType;
    }

    public NotFoundException(StatusCode statusCode, Throwable cause) {
        super(statusCode.getDescription(), cause);
        this.statusCode = statusCode;
        this.statusType = StatusType.ERROR;
    }

    public NotFoundException(StatusCode statusCode, StatusType statusType, Throwable cause) {
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
