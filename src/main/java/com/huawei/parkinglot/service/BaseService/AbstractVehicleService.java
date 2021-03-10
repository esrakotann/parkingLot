package com.huawei.parkinglot.service.BaseService;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.dto.LocateDTO;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.enumeration.VehicleSize;
import com.huawei.parkinglot.repository.ParkingAreaRepository;
import com.huawei.parkinglot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractVehicleService<T extends Vehicle> {

    @Autowired
    VehicleRepository<T> repository;

    @Autowired
    ParkingAreaRepository parkingAreaRepository;

    @Value("${vehicle.big.price}")
    private Double bigPrice;
    @Value("${vehicle.mid.price}")
    private Double midPrice;
    @Value("${vehicle.sma.price}")
    private Double smaPrice;

    public double getPrice(VehicleSize size){

        if(size.equals(VehicleSize.BIG)){
            return bigPrice;
        }else if(size.equals(VehicleSize.MID)){
            return midPrice;
        }else if(size.equals(VehicleSize.SMA)){
            return smaPrice;
        }
        return 0;
    }

    public T get(Long id){
        return repository.findById(id).orElse(null);
    }

    public CheckoutDTO doProcess(T vehicle){

        CheckoutDTO checkoutDTO = new CheckoutDTO();

        Date date1 = null;
        Date date2 = null;

        Date exitDate = new Date();
        Date entryDate = vehicle.getEntrydate();

        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        try{
            date1 = format.parse(entryDate.toString());
            date2 = format.parse(exitDate.toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = date2.getTime() - date1.getTime();
        long diffHours = diff / (60 * 60 * 1000);
        checkoutDTO.setHour(diffHours);
        Double price = this.getPrice(vehicle.getSize());
        if(diffHours == 0){
            checkoutDTO.setPrice(price);
        } else {
           checkoutDTO.setPrice(diffHours * price);
        }
        checkoutDTO.setPlate(vehicle.getLicensePlate());
        ParkingArea area = vehicle.getParkingArea();
        area.setIsEmpty(true);
        parkingAreaRepository.save(area);

        return checkoutDTO;

    }
    public T save(T vehicle){
        return repository.save(vehicle);
    }

    public LocateDTO setLocate(T vehicle) throws Exception {
        ParkingArea area = parkingAreaRepository.findFirstByIsEmptyIsTrue();
        LocateDTO locateDTO;
        if(area != null){
            area.setVehicle(vehicle);
            area.setIsEmpty(false);
            parkingAreaRepository.save(area);

            vehicle.setParkingArea(area);
            Date entryDate = new Date();
            vehicle.setEntrydate(entryDate);
            vehicle = this.save(vehicle);
            locateDTO=new LocateDTO();
            locateDTO.setAreaName(area.getName());
            locateDTO.setCarPlate(vehicle.getLicensePlate());
        } else{
            throw new Exception("Otoparkta boş alan kalmamıştır! ");
        }
        return locateDTO;
    }
}
