package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Expenditure;
import com.tms.rakhubovskiy.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExpenditureServiceImpl implements ExpenditureService{

    private final ExpenditureRepository expenditureRepository;

    @Autowired
    public ExpenditureServiceImpl(ExpenditureRepository expenditureRepository) {
        this.expenditureRepository = expenditureRepository;
    }

    @Override
    public List<Expenditure> findAllByUserId(Long userId) {
        return expenditureRepository.findAllByUserId(userId);
    }

    @Override
    public Expenditure saveExp(Expenditure exp) {
        return expenditureRepository.save(exp);
    }

    @Override
    public void deleteExpenditureById(Long expId) {
        expenditureRepository.deleteById(expId);
    }
}
