package com.sparta.bookloan.entity;

import com.sparta.bookloan.dto.BookRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "book")       //명확하게 table을 지정하기 위해 사용.
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)       //DB가 이미 구축되어 있는 경우, name은 컬럼명과 동일하도록.
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "registrationDate", nullable = false)
    private Date registrationDate;

    //@NoArgsConstructor
    public Book(){

    }

    public Book(BookRequestDto bookResponseDto) {
        this.id = bookResponseDto.getId();
        this.title = bookResponseDto.getTitle();
        this.author = bookResponseDto.getAuthor();
        this.language = bookResponseDto.getLanguage();
        this.publisher = bookResponseDto.getPublisher();
        this.registrationDate = bookResponseDto.getRegistrationDate();
    }
}
