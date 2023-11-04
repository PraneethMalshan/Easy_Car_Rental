package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.servise.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service ;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(CustomerDTO dto) {
        try {
            service.saveCustomer(dto);
            return new ResponseUtil("Ok", "Successfully added...!", dto.getNicNo());
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil("Error", "Failed to save customer", null);
    }
}


   /* @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        if (repo.existsById(dto.getLicenceNo())) {
            throw new RuntimeException("Driver already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Customer.class));


        service.saveCustomer(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }*/

    @PostMapping(path = "/{check}")
    public ResponseUtil checkPassword(CustomerDTO dto){
        System.out.println(dto.getUsername());
        System.out.println(dto.getPassword());
        service.getCustomer(dto);
        return new ResponseUtil("OK", "true",dto);
    }


    @DeleteMapping(params = {"nicNo"})
    public ResponseUtil deleteCustomer(@RequestParam String nicNo){
        service.deleteCustomer(nicNo);
        return new ResponseUtil("OK","Successfully Deleted. : "+nicNo,null);

    }


    @GetMapping
    public ResponseUtil getAllCustomeers(){
        return new ResponseUtil("OK","Successfully Loaded. : ",service.getAllCustomers());
    }


}
