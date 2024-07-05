package com.sparta.bookloan.repository;

import com.sparta.bookloan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Generic은 Wrapper type만 가능
public interface UserRepository extends JpaRepository<User, Long> {
}