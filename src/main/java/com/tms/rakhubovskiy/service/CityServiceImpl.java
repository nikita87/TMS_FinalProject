package com.rakhubovskiy.travelplanningservice.service;

import com.rakhubovskiy.travelplanningservice.model.City;
import com.rakhubovskiy.travelplanningservice.repository.CityRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private  final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findCitiesByCountryCode(String countryCode) {
        List<City> cities = cityRepository.findCitiesByCountryCode(countryCode);
        return cities;
    }
}
