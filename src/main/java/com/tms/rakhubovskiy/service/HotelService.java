package com.rakhubovskiy.travelplanningservice.service;

import com.rakhubovskiy.travelplanningservice.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> findAll();

    Hotel saveHotel(Hotel hotel);

    void deleteHotelById (Long hotelId);

    List<Hotel> findHotelsByHotelClass(String hotelClass);

}
