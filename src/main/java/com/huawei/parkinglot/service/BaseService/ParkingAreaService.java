package com.huawei.parkinglot.service.BaseService;

import com.huawei.parkinglot.entity.ParkingArea;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ParkingAreaService {

    ParkingArea save(ParkingArea parkingArea);
}