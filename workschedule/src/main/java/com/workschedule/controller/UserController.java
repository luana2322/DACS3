package com.workschedule.controller;

import com.workschedule.Exception.NotFoundException;
import com.workschedule.dto.UserDto;
import com.workschedule.model.Users;
import com.workschedule.service.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public Users login(@RequestBody UserDto userDto) throws NotFoundException {
        return userServiceImpl.logintest(userDto);
    }

    @GetMapping("/logintest")
    public UserDto logintest(@RequestBody UserDto userDto) throws NotFoundException {
        return userServiceImpl.login(userDto);
    }

    @PostMapping("/updateuser")
    public ResponseEntity<Users> updateuser(@RequestBody @Valid UserDto userDto
            ,BindingResult bindingResult,
              @RequestParam("userId") Long userId) throws Exception {
//if (bindingResult.hasErrors()){
//    throw new  Exception("Wrong data");
//}
        return ResponseEntity.ok(userServiceImpl.update(userDto,userId));
    }




}
