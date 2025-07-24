package com.paydayplanner.repository;

import java.time.LocalDate;
import java.util.List;

import com.paydayplanner.model.Paycheck;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaycheckRepository implements PanacheRepository<Paycheck> {
	
	public List<Paycheck> findByMonth(int year, int month) {
	    LocalDate start = LocalDate.of(year, month, 1);
	    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
	    return find("date >= ?1 and date <= ?2", start, end).list();
	}
	
}
