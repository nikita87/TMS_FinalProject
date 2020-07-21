package com.tms.rakhubovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
public class Country extends BaseEntity {

    @NaturalId
    @Column(name = "Code", unique = true)
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Continent")
    @Enumerated(value = EnumType.STRING)
    private EnumContinets continent;

    @Column(name = "Region")
    private String region;

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", region='" + region + '\'' +
                '}';
    }
}



