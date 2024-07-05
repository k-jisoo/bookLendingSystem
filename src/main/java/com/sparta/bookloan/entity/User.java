package com.sparta.bookloan.entity;

import com.sparta.bookloan.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "ssn", nullable = false, unique = true)
    private String ssn;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

//    @Column(name = "returnState")
//    private boolean returnState = true;

    //@NoArgsConstructor
    public User(){

    }

    public User(UserRequestDto userRequestDto){
        this.id = userRequestDto.getId();
        this.username = userRequestDto.getUsername();
        this.gender = userRequestDto.getGender();
        this.address = userRequestDto.getAddress();
        this.phone = userRequestDto.getPhone();
        this.ssn = userRequestDto.getSsn();
    }
}

