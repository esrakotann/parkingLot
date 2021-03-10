package com.huawei.parkinglot.service.BaseService;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import org.springframework.transaction.annotation.Transactional;

/**
 * Calculations will be placed on each vehicle type
 */
@Transactional
public interface VehicleService<T extends Vehicle> {

	CheckoutDTO checkOut(T vehicle);

}
