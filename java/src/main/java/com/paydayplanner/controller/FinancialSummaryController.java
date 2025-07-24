package com.paydayplanner.controller;

import com.paydayplanner.service.FinancialSummaryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;

@Path("/summary")
@Produces(MediaType.APPLICATION_JSON)
public class FinancialSummaryController {

    @Inject
    FinancialSummaryService summaryService;

    // Monthly calculation endpings
    
    @GET
    @Path("/net")
    public BigDecimal getNet() {
        return summaryService.getCurrentMonthNet();
    }

    @GET
    @Path("/income")
    public BigDecimal getIncome() {
        return summaryService.getCurrentMonthIncome();
    }

    @GET
    @Path("/expenses")
    public BigDecimal getExpenses() {
        return summaryService.getCurrentMonthExpenses();
    }
    
    // yearly calculation endpoints can be added here in the future.
    
}
