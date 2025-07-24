package com.paydayplanner.repository;

import java.time.LocalDate;
import java.util.List;

import com.paydayplanner.model.Bill;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BillRepository implements PanacheRepository<Bill> { 
	public List<Bill> findByMonth(int year, int month) {
	    LocalDate start = LocalDate.of(year, month, 1);
	    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
	    return find("date >= ?1 and date <= ?2", start, end).list();
	}
	
	
}
