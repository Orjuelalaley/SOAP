package com.example.SOAP.endpoint;

import com.example.SOAP.service.UserService;
import com.g4.spring_boot_soap_example.GetUserRequest;
import com.g4.spring_boot_soap_example.GetUserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {

    private final UserService userService;

    @Autowired
    public UserEndPoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot( namespace = "https://g4.com/spring-boot-soap-example",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }


}
