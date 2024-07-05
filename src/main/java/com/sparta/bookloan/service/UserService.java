package com.sparta.bookloan.service;

import com.sparta.bookloan.dto.BookResponseDto;
import com.sparta.bookloan.dto.UserRequestDto;
import com.sparta.bookloan.dto.UserResponseDto;
import com.sparta.bookloan.entity.User;
import com.sparta.bookloan.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto) {
        try {
            User createdUser = userRepository.save((convertToEntity(userRequestDto)));
            return ResponseEntity.created(URI.create(createdUser.getId().toString()))
                    .body(new UserResponseDto(createdUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private User convertToEntity(UserRequestDto userRequestDto) {
        User user = new User();

        user.setGender(userRequestDto.getGender());
        user.setSsn(userRequestDto.getSsn());
        user.setAddress(userRequestDto.getAddress());
        user.setPhone(userRequestDto.getPhone());
        user.setUsername(userRequestDto.getUsername());

        return user;
    }
}
