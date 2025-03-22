package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.User;
import java.util.List;

import com.example.demo.service.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping(value = "/user/create")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.createUser(user);
    }

    @PutMapping(value = "/user/update")
    public String updateUser()
    {
        return userServiceImpl.updateUser(null);
    }

    @DeleteMapping(value = "/user/delete")
    public String deleteUser()
    {
        return userServiceImpl.deleteUser(12);
    }

    @GetMapping(value = "/user/details")
    public List<User> getUser()
    {

        return userServiceImpl.getUser();
    }

}