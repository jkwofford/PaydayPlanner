package com.paydayplanner.repository;

import com.paydayplanner.model.Paycheck;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaycheckRepository implements PanacheRepository<Paycheck> {
}
