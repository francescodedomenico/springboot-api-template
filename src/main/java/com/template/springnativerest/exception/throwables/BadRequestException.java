package com.template.springnativerest.exception.throwables;

import java.util.Objects;

import com.template.springnativerest.exception.responses.StatusCode;
import com.template.springnativerest.exception.responses.StatusType;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {

    protected StatusCode statusCode;
    protected StatusType statusType;

    public BadRequestException(StatusCode statusCode) {
        super(statusCode.getDescription());
        this.statusCode = statusCode;
        this.statusType = StatusType.ERROR;
    }

    public BadRequestException(StatusCode statusCode, StatusType statusType) {
        super(statusCode.getDescription());
        this.statusCode = statusCode;
        this.statusType = statusType;
    }

    public BadRequestException(StatusCode statusCode, Throwable cause) {
        super(statusCode.getDescription(), cause);
        this.statusCode = statusCode;
        this.statusType = StatusType.ERROR;
    }

    public BadRequestException(StatusCode statusCode, StatusType statusType, Throwable cause) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BadRequestException)) {
            return false;
        }
        BadRequestException badRequestException = (BadRequestException) o;
        return Objects.equals(statusCode, badRequestException.statusCode) && Objects.equals(statusType, badRequestException.statusType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, statusType);
    }

    @Override
    public String toString() {
        return "{" +
            " statusCode='" + getStatusCode() + "'" +
            ", statusType='" + getStatusType() + "'" +
            "}";
    }

}
