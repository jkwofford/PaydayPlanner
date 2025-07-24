package com.paydayplanner.service;

import com.paydayplanner.dto.ExpenseDTO;
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
}
