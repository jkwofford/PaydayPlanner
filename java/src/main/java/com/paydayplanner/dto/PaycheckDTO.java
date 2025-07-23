package com.paydayplanner.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaycheckDTO {
    public Long id;
    public BigDecimal amount;
    public LocalDate date;
    public String source;
}
