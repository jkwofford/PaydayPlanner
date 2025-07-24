package com.paydayplanner.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Paycheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public BigDecimal amount;

    @Column(nullable = false)
    public LocalDate date;

    @Column(nullable = false)
    public String source; // e.g. "Employer", "Freelance", etc.

    // Optional: Constructors
    public Paycheck() {}

    public Paycheck(BigDecimal amount, LocalDate date, String source) {
        this.amount = amount;
        this.date = date;
        this.source = source;
    }
}
