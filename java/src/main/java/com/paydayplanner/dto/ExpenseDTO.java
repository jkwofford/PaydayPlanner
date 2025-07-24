package com.paydayplanner.dto;

import com.paydayplanner.model.ExpenseType;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExpenseDTO {
    BigDecimal getAmount();
    LocalDate getDate();
    String getLabel();
    ExpenseType getType();
}
