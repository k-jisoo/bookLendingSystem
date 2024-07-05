package com.sparta.bookloan.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    Long id;
    String username;
    String gender;
    String phone;
    String address;
    String ssn;
}