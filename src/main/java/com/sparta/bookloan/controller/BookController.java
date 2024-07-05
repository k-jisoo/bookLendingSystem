package com.sparta.bookloan.controller;

import com.sparta.bookloan.dto.BookRequestDto;
import com.sparta.bookloan.dto.BookResponseDto;
import com.sparta.bookloan.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController                            //@RestController가 붙지 않으면 @ResponseBody를 GetMapping 아래에 붙여 사용한다. -> 귀찮다.
@RequestMapping("/book")                //@RequestMapping이 붙지 않으면 각각의 GetMapping에 주소를 입력해야한다. -> 귀찮다.
public class BookController {

    private final BookService bookService;

    //@Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }

    @GetMapping(params = "!id")
    public ResponseEntity<List<BookResponseDto>> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(params = "id")
    public ResponseEntity<BookResponseDto> getBook(@RequestParam Long id) {
        return bookService.getBook(id);
    }


}
