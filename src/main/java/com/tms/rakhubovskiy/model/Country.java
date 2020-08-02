package com.tms.rakhubovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@Builder
@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
public class Country extends BaseEntity {

    @Column(name = "countrycode", unique = true)
    private String code;

    @Column(name = "countryname")
    private String name;

    @Column(name = "continent")
    private String continent;

    @Column(name = "region")
    private String region;

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}



