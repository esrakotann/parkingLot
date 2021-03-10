package com.huawei.parkinglot.service;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.entity.vehicle.Minivan;
import com.huawei.parkinglot.service.BaseService.AbstractVehicleService;
import com.huawei.parkinglot.service.BaseService.MinivanService;
import org.springframework.stereotype.Service;

@Service
public class MinivanServiceImpl extends AbstractVehicleService<Minivan> implements MinivanService {


    @Override
    public CheckoutDTO checkOut(Minivan minivan) {

        return doProcess(minivan);
    }
}
