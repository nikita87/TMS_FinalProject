package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Hotel;
import java.util.List;

public interface HotelService {

    List<Hotel> findAll();

    Hotel saveHotel(Hotel hotel);

    void deleteHotelById (Long hotelId);

    List<Hotel> findHotelsByHotelClassAndAddress(String address, String hotelClass);

}
