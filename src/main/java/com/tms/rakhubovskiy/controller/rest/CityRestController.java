package com.tms.rakhubovskiy.controller.rest;

import com.tms.rakhubovskiy.model.City;
import com.tms.rakhubovskiy.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CityRestController {

    private final CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/travelPlanner/cities")
    public List<City> getCountryCode(@RequestParam(value = "countryCode", required = false) String countryCode){
        return cityService.findCitiesByCountryCode(countryCode);
    }

}
