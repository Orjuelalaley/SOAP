package com.example.SOAP.service;

import com.g4.spring_boot_soap_example.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Map<String, User> users = new HashMap<>();
    @PostConstruct
    public void init() {
        System.out.println("UserService started");
        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(1111);
        peter.setSalary(10000);
        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(2222);
        sam.setSalary(20000);
        User samir = new User();
        samir.setName("Samir");
        samir.setEmpId(3333);
        samir.setSalary(30000);
        users.put(samir.getName(), samir);
        users.put(sam.getName(), sam);
        users.put(peter.getName(), peter);
    }
    public User getUsers(String name){
        return users.get(name);
    }
}
