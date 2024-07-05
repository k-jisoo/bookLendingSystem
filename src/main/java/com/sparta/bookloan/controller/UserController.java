package com.sparta.bookloan.controller;

import com.sparta.bookloan.dto.UserRequestDto;
import com.sparta.bookloan.dto.UserResponseDto;
import com.sparta.bookloan.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //@Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

//    @GetMapping
//    public ResponseEntity<List<UserResponseDto>> getUsers() {
//        return userService.getUsers();
//    }
}