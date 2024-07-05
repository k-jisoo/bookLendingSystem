package com.sparta.bookloan.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class BookRequestDto {
    Long id;
    String title;
    String author;
    String publisher;
    String language;
    Date registrationDate;
}
