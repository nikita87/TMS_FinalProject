package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Hotel;
import com.tms.rakhubovskiy.repository.HotelRepository;
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
    public List<Hotel> findHotelsByHotelClassAndAddress(String address, String hotelClass) {
        return hotelRepository.findHotelsByHotelClassAndAddress(address, hotelClass);
    }
}
