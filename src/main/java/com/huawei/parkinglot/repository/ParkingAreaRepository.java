package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.ParkingArea;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingAreaRepository extends GenericRepository<ParkingArea> {

    ParkingArea findFirstByIsEmptyIsTrue();

}
