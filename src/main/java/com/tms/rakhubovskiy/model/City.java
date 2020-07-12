package com.rakhubovskiy.travelplanningservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseEntity{

    @Column(name = "Name")
    private String name;

    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private String countryCode;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private Long population;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}

