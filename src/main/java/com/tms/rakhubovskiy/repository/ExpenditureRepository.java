package com.tms.rakhubovskiy.repository;

import com.tms.rakhubovskiy.model.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long>{
    List<Expenditure> findAllByUserId(Long userId);
}
