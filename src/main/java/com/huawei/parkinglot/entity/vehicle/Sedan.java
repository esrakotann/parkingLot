package com.huawei.parkinglot.entity.vehicle;

import com.huawei.parkinglot.enumeration.VehicleSize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sedan")
@Getter @Setter
public class Sedan extends Vehicle{

    private VehicleSize size = VehicleSize.SMA;

}
