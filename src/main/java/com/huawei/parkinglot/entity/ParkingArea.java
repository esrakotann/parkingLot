package com.huawei.parkinglot.entity;

import com.huawei.parkinglot.entity.vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parkingArea")
@Getter
@Setter
public class ParkingArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Boolean isEmpty= Boolean.TRUE;

    @OneToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;
}
