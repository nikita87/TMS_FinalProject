package com.rakhubovskiy.travelplanningservice.service;

import com.rakhubovskiy.travelplanningservice.model.City;

import java.util.List;

public interface CityService {

    List<City> findCitiesByCountryCode(String countryCode);
}
