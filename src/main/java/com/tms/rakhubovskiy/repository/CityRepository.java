package com.tms.rakhubovskiy.repository;

import com.tms.rakhubovskiy.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c where c.countryCode = :countrycode")
    List<City> findCitiesByCountryCode(@Param("countrycode") String countrycode);


}
