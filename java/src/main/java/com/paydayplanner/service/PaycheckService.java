package com.paydayplanner.service;

import com.paydayplanner.dto.PaycheckDTO;
import com.paydayplanner.model.Paycheck;
import com.paydayplanner.repository.PaycheckRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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
    public List<PaycheckDTO> listAll() {
        return repo.listAll().stream().map(p -> {
            PaycheckDTO dto = new PaycheckDTO();
            dto.id = p.id;
            dto.amount = p.amount;
            dto.date = p.date;
            dto.source = p.source;
            return dto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
