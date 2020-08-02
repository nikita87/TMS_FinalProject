package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Expenditure;

import java.util.List;

public interface ExpenditureService {

    List<Expenditure> findAllByUserId(Long userId);

    Expenditure saveExp (Expenditure exp);

    void deleteExpenditureById (Long expId);

    double getSumPriceExpenditure(Long userId);

}
