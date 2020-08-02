package com.tms.rakhubovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor
public class Hotel extends BaseEntity {

    @Column(name = "hotelname")
    private String hotelName;

    @Column(name = "hotelclass")
    private String hotelClass;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;*/

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelClass='" + hotelClass + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
