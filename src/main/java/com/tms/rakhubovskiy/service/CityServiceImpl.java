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

    /*@Override
    public List<City> findAllByCountry_code(String countryCode) {
        List<City> cities = cityRepository.findAllByCountry_code(countryCode);
        return cities;
    }*/

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCityById(Long id) {
        cityRepository.deleteById(id);
    }


}
