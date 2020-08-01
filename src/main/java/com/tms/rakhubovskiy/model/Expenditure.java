package com.tms.rakhubovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "expenditures")
@NoArgsConstructor
@AllArgsConstructor
public class Expenditure extends BaseEntity {

    @Column(name = "name")
    private String expName;

    @Column(name = "price")
    private Double expPrice;

    @Column(name = "currency")
    private String currency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return "Expenditure{" +
                "expName='" + expName + '\'' +
                ", expPrice='" + expPrice + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
