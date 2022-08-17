package com.template.springnativerest.exception.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

/**
 * Status represents the status of the response
 */
public class Status {

    // required attributes
    private Integer id;
    private StatusCode code;
    private StatusType type;

    // optional attributes
    private String message;

    public Status() {
    }

    public Status(int id, StatusCode code, StatusType type, String errorMessage) {
        this.id = id;
        this.code = code;
        this.type = type;
        if(errorMessage==null)
            this.message = code.getDescription();
        else
            this.message = errorMessage;
    }

    public static Status createSuccessStatus() {
        return new Status(0, StatusCode.HTTP_200, StatusType.SUCCESS, null);
    }

    public static Status createErrorStatus(StatusCode code, StatusType type) {
        return new Status(1, code, type, null);
    }
    public static Status createErrorStatus(StatusCode code, StatusType type, String errorMessage) {
        return new Status(1, code, type, errorMessage);
    }

    /**
     * Return 0 for success and 1 for error
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    public StatusCode getCode() {
        return code;
    }

    public StatusType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public boolean isErrorStatus() {
        return id == 1;
    }

    @JsonIgnore
    public boolean isOKStatus() {
        return id == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return id.equals(status.id) &&
                code == status.code &&
                type == status.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, type);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", code=" + code +
                ", type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}
