package lk.ijse.spring.servise;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;


import java.util.ArrayList;

public interface CustomerService {
    void getCustomer(CustomerDTO dto);
    public void saveCustomer(CustomerDTO dto);
    public void deleteCustomer(String nicNo);
    public void updateCustomer(CustomerDTO dto);
    public ArrayList<CustomerDTO> getAllCustomers();

}
