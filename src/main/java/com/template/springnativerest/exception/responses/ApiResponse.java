package com.template.springnativerest.exception.responses;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable{

    private Status status;

    private T data;

    public ApiResponse() {
    }

    public ApiResponse(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    public static ApiResponse<Void> successReponse() {
        return new ApiResponse<>(Status.createSuccessStatus(), null);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
