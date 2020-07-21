package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.City;
import com.tms.rakhubovskiy.repository.CityRepository;
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
