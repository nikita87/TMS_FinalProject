package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.City;
import java.util.List;

public interface CityService {

    List<City> findAll();

    City saveCity(City city);

    void deleteCityById(Long id);

    List<City> findCitiesByCountryCode(String countryCode);


}
