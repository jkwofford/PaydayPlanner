package com.paydayplanner.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Expense {
    BigDecimal getAmount();
    LocalDate getDate();
    String getLabel(); // e.g. "Rent", "Spotify", etc.
    ExpenseType getType();
}
