package lk.ijse.spring.servise.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.servise.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;
    @Autowired
    private AdminRepo repo ;

    @Autowired
    private ModelMapper mapper ;

    @Override
    public void getAdmin(AdminDTO dto) {
        Admin map = mapper.map(dto, Admin.class);
        System.out.println(map.getUsername());
        System.out.println(map.getPassword());
        Admin admin = repo.searchAdminWithUserName(map.getUsername());

        if (admin.getUsername().equals(map.getUsername())&& admin.getPassword().equals(map.getPassword())){

        }else {
            throw new RuntimeException( " wrong username or password");
        }
    }
}
