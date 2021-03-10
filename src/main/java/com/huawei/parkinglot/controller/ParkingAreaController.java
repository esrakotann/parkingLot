package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.vehicle.Minivan;
import com.huawei.parkinglot.service.BaseService.ParkingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkingArea")
public class ParkingAreaController {

    @Autowired
    ParkingAreaService parkingAreaService;


    @PostMapping("/saveParkingArea")
    public ResponseEntity<ParkingArea> saveParkingArea(@RequestBody ParkingArea parkingArea) {
        ParkingArea newEntity = null;
        if(parkingArea != null){
            newEntity = parkingAreaService.save(parkingArea);
        }
        return ResponseEntity.ok(newEntity);
    }

}
