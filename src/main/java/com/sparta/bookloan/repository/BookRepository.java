package com.sparta.bookloan.repository;

import com.sparta.bookloan.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}