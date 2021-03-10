package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.dto.LocateDTO;
import com.huawei.parkinglot.entity.vehicle.SUV;
import com.huawei.parkinglot.service.SUVServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suv")
public class SUVController {

    @Autowired
    SUVServiceImpl suvService;

    @GetMapping("/getSUV")
    public ResponseEntity<SUV> getSUV(@RequestParam("id") Long id) {
        return ResponseEntity.ok(suvService.get(id));
    }

    @PostMapping("/entryMinivan")
    public ResponseEntity<SUV> saveMinivan(@RequestBody SUV suv) {
        SUV newEntity = null;
        if(suv != null){
            newEntity = suvService.save(suv);
        }
        return ResponseEntity.ok(newEntity);
    }

    @PostMapping("/locateSUV")
    public ResponseEntity<LocateDTO> locateSUV(@RequestBody SUV suv) throws Exception {
        LocateDTO locateDTO=null;
        try{
            if(suv != null) {
                locateDTO = suvService.setLocate(suv);
            }
        }catch (Exception exception){
            throw new Exception("SUV'a yer tahsis edilirken hata alındı. Hata Detayı:  " +
                    exception.getMessage());
        }
        return ResponseEntity.ok(locateDTO);
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutDTO> checkoutSUV(@RequestBody SUV suv) throws Exception {
        CheckoutDTO checkoutDTO=null;
        try{
            if(suv != null) {
                checkoutDTO = suvService.checkOut(suv);
            }
        }catch (Exception exception){
            throw new Exception("SUV çıkış yaparken hata alındı. Hata Detayı:  " +
                    exception.getMessage());
        }
        return ResponseEntity.ok(checkoutDTO);
    }
}