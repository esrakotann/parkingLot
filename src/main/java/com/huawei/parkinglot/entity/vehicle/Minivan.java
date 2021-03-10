package com.huawei.parkinglot.entity.vehicle;

import com.huawei.parkinglot.enumeration.VehicleSize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "minivan")
@Getter @Setter
public class Minivan extends Vehicle{

    private VehicleSize size = VehicleSize.BIG;

}
