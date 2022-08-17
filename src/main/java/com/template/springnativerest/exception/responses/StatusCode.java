package com.template.springnativerest.exception.responses;

public enum StatusCode {

    /*
     * Information code belows to 100
     * Success code belows to 200
     * Error code belows to 500
     */
    /**************** General codes ****************/
    HTTP_404("Not Found"),
    HTTP_400("Bad Request"),
    HTTP_500("Internal Server Error"),
    HTTP_200("Success");

    private final String description;

    StatusCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
