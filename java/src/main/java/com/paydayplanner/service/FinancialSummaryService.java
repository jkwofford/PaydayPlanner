package com.paydayplanner.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

import com.paydayplanner.dto.MonthlySummaryDTO;
import com.paydayplanner.logic.MonthlySummaryProcessor;

/**
 * The main service that handles the financial calculations.
 */
@ApplicationScoped
public class FinancialSummaryService {

    @Inject
    PaycheckService paycheckService;

    @Inject
    ExpenseService expenseService;

    public BigDecimal getCurrentMonthNet() {
        BigDecimal income = paycheckService.getCurrentMonthIncome();
        BigDecimal expenses = expenseService.getCurrentMonthTotalExpenses();
        return income.subtract(expenses);
    }

    public BigDecimal getCurrentMonthIncome() {
        return paycheckService.getCurrentMonthIncome();
    }

    public BigDecimal getCurrentMonthExpenses() {
        return expenseService.getCurrentMonthTotalExpenses();
    }
    
    @Inject
    MonthlySummaryProcessor processor;

    public MonthlySummaryDTO getMonthlySummary(int year, int month) {
        return processor.compute(year, month);
    }
}
