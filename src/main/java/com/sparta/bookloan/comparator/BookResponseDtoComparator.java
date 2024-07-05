package com.sparta.bookloan.comparator;

import com.sparta.bookloan.dto.BookResponseDto;

import java.util.Comparator;

public class BookResponseDtoComparator implements Comparator<BookResponseDto> {
    @Override
    public int compare(BookResponseDto o1, BookResponseDto o2) {
        return o1.getRegistrationDate().compareTo(o2.getRegistrationDate());
    }
}
