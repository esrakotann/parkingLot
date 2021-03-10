package com.huawei.parkinglot.service;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.entity.vehicle.SUV;
import com.huawei.parkinglot.service.BaseService.AbstractVehicleService;
import com.huawei.parkinglot.service.BaseService.SUVService;
import org.springframework.stereotype.Service;

@Service
public class SUVServiceImpl extends AbstractVehicleService<SUV> implements SUVService {

    @Override
    public CheckoutDTO checkOut(SUV vehicle) {
        return doProcess(vehicle);
    }
}
