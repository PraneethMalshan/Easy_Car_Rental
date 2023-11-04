package lk.ijse.spring.controller;

import lk.ijse.spring.servise.CarRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CarRent")
@CrossOrigin // will support to cors requests
public class CarRentController {

    @Autowired
    CarRentService service;

}
