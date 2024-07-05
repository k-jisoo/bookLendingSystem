package com.sparta.bookloan.dto;

import com.sparta.bookloan.entity.Book;
import lombok.Getter;

import java.util.Date;

@Getter
public class BookResponseDto {
    Long id;
    String title;
    String author;
    String publisher;
    String language;
    Date registrationDate;

    public BookResponseDto(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book parameter is null");
        }

        this.id = book.getId();
        this.title = book.getAuthor();
        this.author = book.getTitle();
        this.publisher = book.getPublisher();
        this.language = book.getLanguage();
        this.registrationDate = book.getRegistrationDate();
    }
}
