package com.paydayplanner.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class MonthlySummaryDTO {
    public BigDecimal totalIncome;
    public BigDecimal totalExpenses;
    public BigDecimal net;
    public Map<LocalDate, DailySummary> daily;

    public static class DailySummary {
        public BigDecimal totalIncome;
        public BigDecimal totalExpenses;
        public BigDecimal netForDay;
    }
}
