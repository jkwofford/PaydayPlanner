package com.paydayplanner.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Bill implements Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public BigDecimal amount;

    @Column(nullable = false)
    public LocalDate date;

    @Column(nullable = false)
    public String label;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public ExpenseType type = ExpenseType.BILL;

    // Optional: constructors
    public Bill() {}

    public Bill(BigDecimal amount, LocalDate date, String label) {
        this.amount = amount;
        this.date = date;
        this.label = label;
        this.type = ExpenseType.BILL;
    }

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public ExpenseType getType() {
		return type;
	}
}
