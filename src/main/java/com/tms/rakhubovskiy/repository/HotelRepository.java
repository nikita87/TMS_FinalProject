package com.rakhubovskiy.travelplanningservice.repository;

import com.rakhubovskiy.travelplanningservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository <Hotel, Long>{

    @Query("select h from Hotel h where h.hotelClass = :hotelClass")
    List<Hotel> findHotelsByHotelClass(@Param("hotelClass") String hotelClass);

}
