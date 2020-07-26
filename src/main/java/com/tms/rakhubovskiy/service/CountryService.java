package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Country;

import java.util.List;

public interface CountryService {

   List<Country> findAll();

   Country saveCountry(Country country);

   void deleteCountryById(Long id);
}
