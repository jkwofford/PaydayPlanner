package com.paydayplanner.service;

import com.paydayplanner.dto.PaycheckDTO;
import com.paydayplanner.model.Paycheck;
import com.paydayplanner.repository.PaycheckRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PaycheckService {

    @Inject
    PaycheckRepository repo;

    @Transactional
    public void create(PaycheckDTO dto) {
        Paycheck p = new Paycheck();
        p.amount = dto.amount;
        p.date = dto.date;
        p.source = dto.source;
        repo.persist(p);
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    // TODO: need to make a all endpoint so you can list paychecks (as a map?)
    
    public BigDecimal getCurrentMonthIncome() {
        LocalDate now = LocalDate.now();
        List<Paycheck> paychecks = repo.findByMonth(now.getYear(), now.getMonthValue());

        return paychecks.stream()
                .map(p -> p.amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}
