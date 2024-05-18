package com.workschedule.controller;

import com.workschedule.Exception.NotFoundException;
import com.workschedule.dto.UserDto;
import com.workschedule.model.Users;
import com.workschedule.service.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
    private UserServiceImpl userServiceImpl;

@PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody @Valid UserDto userDto
        ,BindingResult bindingResult ) throws Exception {
//if (bindingResult.hasErrors()){
//    throw new  Exception("Wrong data");
//}
    return ResponseEntity.ok(userServiceImpl.save(userDto));
}

@GetMapping("/login")
    public Users login(@RequestBody UserDto userDto) throws NotFoundException {
    return userServiceImpl.login(userDto);
}

}
