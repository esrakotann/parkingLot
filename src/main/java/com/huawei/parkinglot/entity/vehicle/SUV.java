package com.huawei.parkinglot.entity.vehicle;

import com.huawei.parkinglot.enumeration.VehicleSize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "suv")
@Getter @Setter
public class SUV extends Vehicle {

    private VehicleSize size = VehicleSize.SMA;

}