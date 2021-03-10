package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.dto.CheckoutDTO;
import com.huawei.parkinglot.dto.LocateDTO;
import com.huawei.parkinglot.entity.vehicle.Minivan;
import com.huawei.parkinglot.service.MinivanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/minivan")
public class MinivanController {

    @Autowired
    MinivanServiceImpl minivanService;

    @GetMapping("/getMinivan")
    public ResponseEntity<Minivan> getMinivan(@RequestParam("id") Long id) {
        return ResponseEntity.ok(minivanService.get(id));
    }

    @PostMapping("/entryMinivan")
    public ResponseEntity<Minivan> saveMinivan(@RequestBody Minivan minivan) {
        Minivan newEntity = null;
        if(minivan != null){
            newEntity = minivanService.save(minivan);
        }
        return ResponseEntity.ok(newEntity);
    }

    @PostMapping("/locateMinivan")
    public ResponseEntity<LocateDTO> locateMinivan(@RequestBody Minivan minivan) throws Exception {
        LocateDTO locateDTO=null;
        try{

            if(minivan != null) {
                locateDTO = minivanService.setLocate(minivan);
            }
        }catch (Exception exception){
           throw new Exception("Minivan'a yer tahsis edilirken hata alındı. Hata Detayı:  " +
                   exception.getMessage());
        }
        return ResponseEntity.ok(locateDTO);
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutDTO> checkoutMinivan(@RequestBody Minivan minivan) throws Exception {
        CheckoutDTO checkoutDTO=null;
        try{
            if(minivan != null) {
                checkoutDTO = minivanService.checkOut(minivan);
            }
        }catch (Exception exception){
            throw new Exception("Minivan çıkış yaparken hata alındı. Hata Detayı:  " +
                    exception.getMessage());
        }
        return ResponseEntity.ok(checkoutDTO);
    }
}