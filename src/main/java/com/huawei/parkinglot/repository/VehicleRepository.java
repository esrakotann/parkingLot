package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.vehicle.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository<T extends Vehicle> extends GenericRepository<T> {
}
