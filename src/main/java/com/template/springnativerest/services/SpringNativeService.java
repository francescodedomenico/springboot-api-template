
package com.template.springnativerest.services;

import org.springframework.stereotype.Service;

import com.template.springnativerest.exception.responses.StatusCode;
import com.template.springnativerest.exception.responses.StatusType;
import com.template.springnativerest.exception.throwables.BadRequestException;

@Service
public class SpringNativeService {

    public void testException(){
        throw new BadRequestException(StatusCode.HTTP_400, StatusType.BAD_REQUEST);
    }
}
