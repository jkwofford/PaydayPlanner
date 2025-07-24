package com.paydayplanner.repository;

import com.paydayplanner.model.Bill;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BillRepository implements PanacheRepository<Bill> { }
