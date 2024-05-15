package com.workschedule.controller;

import com.workschedule.dto.UserDto;
import com.workschedule.model.Users;
import com.workschedule.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
    private UserServiceImpl userServiceImpl;

@PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody UserDto userDto){

    return ResponseEntity.ok(userServiceImpl.save(userDto));
}

@GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserDto userDto){
    if(userServiceImpl.login(userDto)){
        return ResponseEntity.ok(true);
    }else{
        return ResponseEntity.ok(false);
    }
}

}
