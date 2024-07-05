package com.sparta.bookloan.comparator;

import com.sparta.bookloan.dto.LoanResponseDto;

import java.util.Comparator;

public class LoanResponseDtoComparator implements Comparator<LoanResponseDto> {
    @Override
    public int compare(LoanResponseDto o1, LoanResponseDto o2) {
        return o1.getLoanDate().compareTo(o2.getLoanDate());
    }
}
