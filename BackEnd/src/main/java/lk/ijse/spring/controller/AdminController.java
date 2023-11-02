package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.servise.AdminService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service ;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path ="/{check}")
    public ResponseUtil chekPassword(AdminDTO dto){
        System.out.println(dto.getUsername());
        System.out.println(dto.getPassword());
        service.getAdmin(dto);
        return new ResponseUtil("Ok","true",dto);
    }
}
