package com.paydayplanner.controller;

import com.paydayplanner.dto.PaycheckDTO;
import com.paydayplanner.service.PaycheckService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

@Path("/paychecks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaycheckController {

    @Inject
    PaycheckService service;

    @POST
    public Response create(PaycheckDTO dto) {
        service.create(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
    
    @GET
    @Path("/monthly-total")
    public BigDecimal getMonthlyIncome() {
        return service.getCurrentMonthIncome();
    }
    
}
