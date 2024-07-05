package com.sparta.bookloan.entity;

import com.sparta.bookloan.dto.LoanRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "loan")
@Getter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loanDate", nullable = false)
    private Date loanDate;

    @Column(name = "returnDate", nullable = false)
    private Date returnDate;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "bookId", nullable = false)
    private Long bookId;

    @Column(name = "returnState", nullable = false)
    private boolean returnState = true;

    //@NoArgsConstructor
    public Loan(){

    }

    public Loan(LoanRequestDto loanRequestDto){
        this.loanDate = new Date();
        this.returnDate = new Date();
        this.userId = loanRequestDto.getUserId();
        this.bookId = loanRequestDto.getBookId();
    }


    public void setReturnState(boolean b) {
        this.returnState = b;
    }
}
