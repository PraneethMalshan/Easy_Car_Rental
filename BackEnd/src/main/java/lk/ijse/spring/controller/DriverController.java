package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.servise.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service ;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        service.saveDriver(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }

    @DeleteMapping(params = {"licenceNo"})
    public ResponseUtil deleteDriver(@RequestParam String licenceNo){
        service.deleteDriver(licenceNo);
        return new ResponseUtil("OK", "Successfully Deleted. : "+licenceNo, null);
    }

    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto ){
        service.updateDriver(dto);
        return new ResponseUtil("OK", "Successfully Updated. : "+dto.getLicenceNo(), null);
    }

    @GetMapping
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK", "Successfully Loaded. : ",service.getAllDrivers());
    }

}
