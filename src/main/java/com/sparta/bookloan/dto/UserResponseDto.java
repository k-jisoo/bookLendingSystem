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

}
