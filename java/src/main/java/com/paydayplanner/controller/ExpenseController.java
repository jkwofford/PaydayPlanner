package com.paydayplanner.controller;

import com.paydayplanner.dto.BillDTO;
import com.paydayplanner.service.ExpenseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/expenses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseController {

    @Inject
    ExpenseService service;

    @POST
    @Path("/bills")
    public void createBill(BillDTO dto) {
        service.createExpense(dto);
    }
}
