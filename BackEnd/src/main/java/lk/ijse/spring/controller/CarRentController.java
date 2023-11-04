package lk.ijse.spring.controller;

import lk.ijse.spring.entity.CarRent;
import lk.ijse.spring.servise.CarRentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CarRent")
@CrossOrigin // will support to cors requests
public class CarRentController {

    @Autowired
    CarRentService service ;

    @GetMapping(path = "/generateRentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateRentId() {
        return new ResponseUtil("ok", "Ok", service.generateRentId());
    }

    @PostMapping
    public ResponseUtil saveCarRent(@RequestBody CarRent dto ){
        try {
            System.out.println(dto.getRentId());
            System.out.println(dto.getCar().getRegistrationNO());
            System.out.println(dto.getDriver().getNic());
            System.out.println(dto.getCustomer().getNicNo());
            service.saveCarRent(dto);
            return new ResponseUtil("Ok", "Successfully added...!", dto.getRentId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtil("Error", "Failed to save customer", null);
        }


    }



}
