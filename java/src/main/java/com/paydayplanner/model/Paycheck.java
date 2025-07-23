package com.paydayplanner.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Paycheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public BigDecimal amount;
    public LocalDate date;
    public String source; // "Employer", "Freelance", etc.
}
