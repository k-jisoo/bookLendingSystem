package com.sparta.bookloan.controller;

import com.sparta.bookloan.dto.LoanRequestDto;
import com.sparta.bookloan.dto.LoanResponseDto;
import com.sparta.bookloan.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    //@Autowired
    LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(params = "!bookId")
    public ResponseEntity<LoanResponseDto> createLoan(@RequestBody LoanRequestDto loanRequestDto) {
        return loanService.createLoan(loanRequestDto);
    }

    @PostMapping(params = "bookId")
    public ResponseEntity<LoanResponseDto> returnLoan(@RequestParam Long bookId) {
        return loanService.returnLoan(bookId);
    }

    @GetMapping
    public ResponseEntity<List<LoanResponseDto>> getLoanList() {
        return loanService.getLoanList();
    }

}
