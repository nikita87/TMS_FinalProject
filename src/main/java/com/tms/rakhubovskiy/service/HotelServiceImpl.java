package com.rakhubovskiy.travelplanningservice.service;

import com.rakhubovskiy.travelplanningservice.model.Hotel;
import com.rakhubovskiy.travelplanningservice.repository.HotelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotelById(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public List<Hotel> findHotelsByHotelClass(String hotelClass) {
        return hotelRepository.findHotelsByHotelClass(hotelClass);
    }
}
