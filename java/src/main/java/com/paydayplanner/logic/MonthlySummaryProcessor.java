package com.paydayplanner.logic;

import com.paydayplanner.dto.MonthlySummaryDTO;
import com.paydayplanner.model.Bill;
import com.paydayplanner.model.Paycheck;
import com.paydayplanner.repository.BillRepository;
import com.paydayplanner.repository.PaycheckRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class MonthlySummaryProcessor {

    @Inject
    PaycheckRepository paycheckRepository;

    @Inject
    BillRepository billRepository;

    // compute the monthly summary for a given year and month
    public MonthlySummaryDTO compute(int year, int month) {
        List<Paycheck> paychecks = paycheckRepository.findAll().stream()
            .filter(p -> p.date.getYear() == year && p.date.getMonthValue() == month)
            .collect(Collectors.toList());

        List<Bill> bills = billRepository.findAll().stream()
            .filter(b -> b.date.getYear() == year && b.date.getMonthValue() == month)
            .collect(Collectors.toList());

        Map<LocalDate, MonthlySummaryDTO.DailySummary> dailyMap = new TreeMap<>();

        for (Paycheck p : paychecks) {
            dailyMap.computeIfAbsent(p.date, d -> new MonthlySummaryDTO.DailySummary());
            MonthlySummaryDTO.DailySummary day = dailyMap.get(p.date);
            day.totalIncome = (day.totalIncome == null ? BigDecimal.ZERO : day.totalIncome).add(p.amount);
        }

        for (Bill b : bills) {
            dailyMap.computeIfAbsent(b.date, d -> new MonthlySummaryDTO.DailySummary());
            MonthlySummaryDTO.DailySummary day = dailyMap.get(b.date);
            day.totalExpenses = (day.totalExpenses == null ? BigDecimal.ZERO : day.totalExpenses).add(b.amount);
        }

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpenses = BigDecimal.ZERO;

        for (var entry : dailyMap.entrySet()) {
            MonthlySummaryDTO.DailySummary day = entry.getValue();
            day.totalIncome = day.totalIncome == null ? BigDecimal.ZERO : day.totalIncome;
            day.totalExpenses = day.totalExpenses == null ? BigDecimal.ZERO : day.totalExpenses;
            day.netForDay = day.totalIncome.subtract(day.totalExpenses);

            totalIncome = totalIncome.add(day.totalIncome);
            totalExpenses = totalExpenses.add(day.totalExpenses);
        }

        MonthlySummaryDTO summary = new MonthlySummaryDTO();
        summary.totalIncome = totalIncome;
        summary.totalExpenses = totalExpenses;
        summary.net = totalIncome.subtract(totalExpenses);
        summary.daily = dailyMap;

        return summary;
    }
}
