package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.servise.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service ;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto ){
        service.saveCar(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }

    @DeleteMapping(params = {"registrationNO"})
    public ResponseUtil deleteCar(@RequestParam String registrationNO){
        service.deleteCar(registrationNO);
        return new ResponseUtil("OK","Successfully Deleted. : "+registrationNO,null);
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto ){
        service.updateCar(dto);
        return new ResponseUtil("OK","Successfully Updated. : "+dto.getRegistrationNO(),null);
    }


    @GetMapping
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK","Successfully Loaded. : ",service.getAllCars());
    }

}
