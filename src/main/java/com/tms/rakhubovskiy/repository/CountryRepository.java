package com.rakhubovskiy.travelplanningservice.repository;

import com.rakhubovskiy.travelplanningservice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{

}
