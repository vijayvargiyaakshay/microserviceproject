package com.sp.user.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.sp.user.VO.ResponseTemplateVO;
import com.sp.user.entity.User;
import com.sp.user.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser of UserController"); 
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
    
    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Long userId) {
        log.info("Inside get user of UserController");
        System.out.println("This is get user by userid  " + userService.getUser(userId));
        return userService.getUser(userId);
    }



}
