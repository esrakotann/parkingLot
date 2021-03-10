package com.huawei.parkinglot.service;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.entity.vehicle.Sedan;
import com.huawei.parkinglot.service.BaseService.AbstractVehicleService;
import com.huawei.parkinglot.service.BaseService.SedanService;
import org.springframework.stereotype.Service;

@Service
public class SedanServiceImpl extends AbstractVehicleService<Sedan> implements SedanService {

	@Override
	public CheckoutDTO checkOut(Sedan sedan) {
		return doProcess(sedan);
	}
}


