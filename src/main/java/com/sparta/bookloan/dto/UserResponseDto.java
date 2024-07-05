package com.sparta.bookloan.dto;

import com.sparta.bookloan.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    Long id;
    String username;
    String gender;
    String phone;
    String address;
    boolean returnState;

    public UserResponseDto(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Book parameter is null");
        }

        this.id = user.getId();
        this.username = user.getUsername();
        this.gender = user.getGender();
        this.phone = user.getPhone();
        this.address = user.getAddress();
    }

    public UserResponseDto(UserRequestDto UserrequestDto) {
        if (UserrequestDto == null) {
            throw new IllegalArgumentException("Book parameter is null");
        }

        this.id = UserrequestDto.getId();
        this.username = UserrequestDto.getUsername();
        this.gender = UserrequestDto.getGender();
        this.phone = UserrequestDto.getPhone();
        this.address = UserrequestDto.getAddress();
    }

}
