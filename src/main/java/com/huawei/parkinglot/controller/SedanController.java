package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.dto.LocateDTO;
import com.huawei.parkinglot.entity.vehicle.Sedan;
import com.huawei.parkinglot.service.SedanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sedan")
public class SedanController {

    @Autowired
    SedanServiceImpl sedanService;

    @GetMapping("/getSedan")
    public ResponseEntity<Sedan> getSedan(@RequestParam("id") Long id) {
        return ResponseEntity.ok(sedanService.get(id));
    }

    @PostMapping("/entrySedan")
    public ResponseEntity<Sedan> saveSedan(@RequestBody Sedan sedan) {
        Sedan newEntity = null;
        if(sedan != null){
            newEntity = sedanService.save(sedan);
        }
        return ResponseEntity.ok(newEntity);
    }

    @PostMapping("/locateSedan")
    public ResponseEntity<LocateDTO> locateSedan(@RequestBody Sedan sedan) throws Exception {
        LocateDTO locateDTO=null;
        try{
            if(sedan != null) {
                locateDTO = sedanService.setLocate(sedan);
            }
        }catch (Exception exception){
            throw new Exception("Sedan'a yer tahsis edilirken hata alındı. Hata Detayı:  " +
                    exception.getMessage());
        }
        return ResponseEntity.ok(locateDTO);
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutDTO> checkoutSedan(@RequestBody Sedan sedan) throws Exception {
        CheckoutDTO checkoutDTO=null;
        try{
            if(sedan != null) {
                checkoutDTO = sedanService.checkOut(sedan);
            }
        }catch (Exception exception){
            throw new Exception("Sedan çıkış yaparken hata alındı. Hata Detayı:  " +
                    exception.getMessage());
        }
        return ResponseEntity.ok(checkoutDTO);
    }
}



