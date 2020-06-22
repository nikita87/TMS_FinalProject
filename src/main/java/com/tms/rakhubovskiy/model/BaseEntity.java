package com.tms.rakhubovskiy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@Table(indexes = {
        @Index(columnList = "created"),
        @Index(columnList = "updated"),
        @Index(columnList = "active")})
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date created;

    @Column
    private Date updated;

    @Column
    private boolean active;

}
