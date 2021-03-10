package com.huawei.parkinglot.entity.vehicle;

import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.enumeration.VehicleSize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
public class Vehicle {

	@Id
	private String licensePlate;

	@OneToOne(fetch = FetchType.EAGER)
	private ParkingArea  parkingArea;

	@Enumerated(EnumType.STRING)
	private VehicleSize size;

	@Column(nullable = true)
	private Date entrydate;
}
