package lk.ijse.spring.servise.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.servise.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo adminRepo;

    @Autowired
    private CustomerRepo repo ;

    @Autowired
    private ModelMapper mapper ;


    @Override
    public void getCustomer(CustomerDTO dto) {
        Customer map = mapper.map(dto, Customer.class);
        Customer customer = repo.searchCustomerWithUserName(map.getUsername());
        if (customer.getUsername().equals(map.getUsername())&& customer.getPassword().equals(map.getPassword())){

        }else {
            throw new RuntimeException( " wrong username or password");
        }
    }

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getNicNo())){
            throw new RuntimeException("Customer already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String nicNo) {

    }

    @Override
    public void updateCustomer(CustomerDTO dto) {

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return null;
    }
}
