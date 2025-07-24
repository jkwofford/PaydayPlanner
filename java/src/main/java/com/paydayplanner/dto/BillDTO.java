package com.paydayplanner.dto;

import com.paydayplanner.model.ExpenseType;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BillDTO implements ExpenseDTO {
    public Long id;
    public BigDecimal amount;
    public LocalDate date;
    public String label;
    public ExpenseType type = ExpenseType.BILL;

    @Override public BigDecimal getAmount() { return amount; }
    @Override public LocalDate getDate() { return date; }
    @Override public String getLabel() { return label; }
    @Override public ExpenseType getType() { return type; }
}
