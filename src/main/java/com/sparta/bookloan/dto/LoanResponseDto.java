package com.sparta.bookloan.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class LoanResponseDto {
    String Message;
    String username;
    String phone;
    String title;
    String author;
    Date loanDate;

    public LoanResponseDto(String Message) {
        this.Message = Message;
    }

    public LoanResponseDto(String username, String phone, String title, String author, Date loanDate) {
        this.username = username;
        this.phone = phone;
        this.title = title;
        this.author = author;
        this.loanDate = loanDate;
    }
}
