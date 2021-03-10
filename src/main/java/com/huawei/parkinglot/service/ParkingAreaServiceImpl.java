package com.huawei.parkinglot.service;

import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.repository.ParkingAreaRepository;
import com.huawei.parkinglot.service.BaseService.ParkingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingAreaServiceImpl implements ParkingAreaService {

    @Autowired
    ParkingAreaRepository repository;

    @Override
    public ParkingArea save(ParkingArea parkingArea) {
        return repository.save(parkingArea);
    }
}

