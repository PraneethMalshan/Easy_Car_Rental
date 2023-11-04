package lk.ijse.spring.servise;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.io.IOException;
import java.util.ArrayList;

public interface CustomerService {
    public void saveCustomer(CustomerDTO dto) throws IOException;
    void getCustomer(CustomerDTO dto);
    public void deleteCustomer(String nicNo);
    public void updateCustomer(CustomerDTO dto);
    public ArrayList<CustomerDTO> getAllCustomers();

}
