package com.paydayplanner.service;

import com.paydayplanner.dto.ExpenseDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.paydayplanner.dto.BillDTO;
import com.paydayplanner.model.Bill;
import com.paydayplanner.model.ExpenseType;
import com.paydayplanner.repository.BillRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ExpenseService {

    @Inject
    BillRepository billRepo;

    @Transactional
    public void createExpense(ExpenseDTO dto) {
        if (dto.getType() == ExpenseType.BILL && dto instanceof BillDTO billDTO) {
            Bill bill = new Bill();
            bill.amount = billDTO.getAmount();
            bill.date = billDTO.getDate();
            bill.label = billDTO.getLabel();
            bill.type = ExpenseType.BILL;
            billRepo.persist(bill);
        } else {
            throw new UnsupportedOperationException("Unsupported expense type: " + dto.getType());
        }
    }
    
    // TODO: need to make a all endpoint so you can list paychecks (as a map?)
   
    public BigDecimal getCurrentMonthTotalExpenses() {
        LocalDate now = LocalDate.now();
        List<Bill> bills = billRepo.findByMonth(now.getYear(), now.getMonthValue());

        return bills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
