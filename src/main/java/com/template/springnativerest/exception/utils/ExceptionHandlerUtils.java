package com.template.springnativerest.exception.utils;

import com.template.springnativerest.exception.responses.ApiResponse;
import com.template.springnativerest.exception.responses.Status;
import com.template.springnativerest.exception.responses.StatusCode;
import com.template.springnativerest.exception.responses.StatusType;


public class ExceptionHandlerUtils {

    private ExceptionHandlerUtils(){

    }

    public static ApiResponse<Void> handleException(StatusCode statusCode, StatusType statusType) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(Status.createErrorStatus(statusCode, statusType));
        return apiResponse;
    }

    public static ApiResponse<Void> handleException(StatusCode statusCode, StatusType statusType, String errorMessage) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(Status.createErrorStatus(statusCode, statusType, errorMessage));
        return apiResponse;
        
    }

}
