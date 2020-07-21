package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.City;
import java.util.List;

public interface CityService {

    List<City> findCitiesByCountryCode(String countryCode);
}
