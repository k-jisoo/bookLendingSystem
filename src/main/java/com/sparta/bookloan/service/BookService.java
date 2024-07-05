package com.sparta.bookloan.service;

import com.sparta.bookloan.comparator.BookResponseDtoComparator;
import com.sparta.bookloan.dto.BookRequestDto;
import com.sparta.bookloan.dto.BookResponseDto;
import com.sparta.bookloan.entity.Book;
import com.sparta.bookloan.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    //@RequiredArgsConstructor
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<BookResponseDto> createBook(BookRequestDto bookRequestDto) {
        Book book = new Book(bookRequestDto);
        Book createdBook = bookRepository.save(book);
        try {
            return ResponseEntity.created(URI.create(createdBook.getId().toString()))
                    .body(new BookResponseDto(createdBook));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<BookResponseDto> getBook(Long id) {
        try {
            BookResponseDto bookResponseDto = new BookResponseDto(bookRepository.getReferenceById(id));     //id.intValue()에 대한 예외처리 필요
            return ResponseEntity.ok(bookResponseDto);
        } catch (Exception e) {
            return null;
        }
    }

    public ResponseEntity<List<BookResponseDto>> getBooks() {
        try {
            List<BookResponseDto> bookResponseDtoList = bookRepository.findAll().stream().map(BookResponseDto::new).collect(Collectors.toList());
            bookResponseDtoList.sort(new BookResponseDtoComparator());
            return ResponseEntity.ok(bookResponseDtoList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
