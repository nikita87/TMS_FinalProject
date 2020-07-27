package com.tms.rakhubovskiy.repository;

import com.tms.rakhubovskiy.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository <Hotel, Long>{
}
