package com.tms.rakhubovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseEntity {

    @Column(name = "cityname")
    private String cityName;

    @Column(name = "countrycode")
    private String countryCode;

    @Override
    public String toString() {
        return "City{" +
                "cityname='" + cityName + '\'' +
                ", countrycode='" + countryCode + '\'' +
                '}';
    }
}

