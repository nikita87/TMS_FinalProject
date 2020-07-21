package com.tms.rakhubovskiy.model;

import com.sun.prism.impl.FactoryResetException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity {

    @Column(name = "Name")
    private String eventName;

    @Column(name = "Date")
    private String eventDate;

    @Column(name = "Time")
    private String eventTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                '}';
    }
}
