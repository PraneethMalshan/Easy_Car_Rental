package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.servise.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service ;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        service.saveCustomer(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }

    @PostMapping(path = "/{check}")
    public ResponseUtil checkPassword(CustomerDTO dto){
        System.out.println(dto.getUsername());
        System.out.println(dto.getPassword());
        service.getCustomer(dto);
        return new ResponseUtil("OK", "true",dto);
    }


}
