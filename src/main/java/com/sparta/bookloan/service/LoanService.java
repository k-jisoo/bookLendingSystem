package com.sparta.bookloan.service;

import com.sparta.bookloan.comparator.LoanResponseDtoComparator;
import com.sparta.bookloan.dto.LoanRequestDto;
import com.sparta.bookloan.dto.LoanResponseDto;
import com.sparta.bookloan.entity.Book;
import com.sparta.bookloan.entity.Loan;
import com.sparta.bookloan.entity.User;
import com.sparta.bookloan.repository.BookRepository;
import com.sparta.bookloan.repository.LoanRepository;
import com.sparta.bookloan.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    //@RequiredArgsConstructor
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<LoanResponseDto> createLoan(LoanRequestDto loanRequestDto) {

        List<Loan> loanList  = loanRepository.findByBookId(loanRequestDto.getBookId());

        boolean isBookNotReturned = loanList.stream().anyMatch(loan -> !loan.isReturnState());

        if (isBookNotReturned)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoanResponseDto("Not found loaned data for the book. bookId: " + loanRequestDto.getBookId()));

        try {
            Loan loan = new Loan(loanRequestDto);
            loanRepository.save(loan);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new LoanResponseDto("Successfully created a loan. bookId: " + loanRequestDto.getBookId()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoanResponseDto("Database Error"));
        }
    }

    //예외처리 더 생각할 필요 있음. 아침 6시라 머리가 안돌아감.
    public ResponseEntity<LoanResponseDto> returnLoan(Long bookId) {

        List<Loan> FoundLoanList = loanRepository.findByBookId(bookId);

        boolean isBookNotReturned = FoundLoanList.stream().anyMatch(loan -> !loan.isReturnState());

        if (!isBookNotReturned)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoanResponseDto("This book is already returned. bookId: " + bookId));

        FoundLoanList.stream().filter(loan -> !loan.isReturnState()).forEach(loan -> loan.setReturnState(true));

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new LoanResponseDto("This book is already returned. bookId: " + bookId));

    }

    //예외처리 고민 필요. 잠온다.
    public ResponseEntity<List<LoanResponseDto>> getLoanList() {
        List<Loan> loanList = loanRepository.findAll();
        List<LoanResponseDto> loanResponseDtoList = loanList.stream()
                .map(loan -> {
                    Book book = bookRepository.findById(loan.getBookId()).orElse(null);
                    User user = userRepository.findById(loan.getUserId()).orElse(null);
                    if (book == null || user == null)
                        return null;

                    return new LoanResponseDto(user.getUsername(), user.getPhone(), book.getTitle(), book.getAuthor(), loan.getLoanDate());
                }).sorted(new LoanResponseDtoComparator()).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loanResponseDtoList);
    }
}
