package lk.ijse.spring.servise.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.servise.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    /*@Autowired
    CustomerRepo adminRepo;*/  /*---*/

    @Autowired
    private CustomerRepo repo ;

    @Autowired
    private ModelMapper mapper ;


  /*  @Override
    public void saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getNicNo())){
            throw new RuntimeException("Customer already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Customer.class));
    }*/

    /*@Override
    public void saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getNicNo())){
            throw new RuntimeException("Customer Already Exists.. Please Another ID.. ");
        }
        repo.save(mapper.map(dto, Customer.class));
    }
*/
@Override
    public void saveCustomer(CustomerDTO dto) throws IOException {
        if (repo.existsById(dto.getNicNo())) {
            throw new RuntimeException(dto.getNicNo() + " already exists");
        }
//        String uploadDir = "D:\\WorkSpace\\GDSE\\WorkingZone\\AAD_CourseWork\\EasyCar_Rental\\BackEnd\\src\\main\\resources\\files\\";
        String uploadDir = "F:\\Praneeth\\IJSE\\AAD\\My_AAD_Final_Project\\EasyCar_Rental\\BackEnd\\src\\main\\resources\\Photo\\";
        MultipartFile nicFrontImg = dto.getNicFrontImg();
        MultipartFile licenceImg = dto.getNicBackImg();


        nicFrontImg.transferTo(new File(uploadDir, nicFrontImg.getOriginalFilename()));
        licenceImg.transferTo(new File(uploadDir, licenceImg.getOriginalFilename()));
        repo.save(new Customer(
                dto.getNicNo(),
                dto.getLicenceNo(),
                dto.getName(),
                dto.getAddress(),
                dto.getContactNo(),
                dto.getEmail(),
                dto.getUsername(),
                dto.getPassword(),
                nicFrontImg.getOriginalFilename(),
                licenceImg.getOriginalFilename()

                ));

    }

    @Override
    public void getCustomer(CustomerDTO dto) {
        Customer map = mapper.map(dto, Customer.class);
        Customer customer = repo.searchCustomerWithUserName(map.getUsername());
        if (customer.getUsername().equals(map.getUsername())&& customer.getPassword().equals(map.getPassword())){

        } else {
            throw new RuntimeException( "wrong username or password");
        }
    }



    @Override
    public void deleteCustomer(String nicNo) {
        if (!repo.existsById(nicNo)){
            throw new RuntimeException("Wrong ID. Please enter valid ID..");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {

        return mapper.map(repo.findAll(), new TypeToken<ArrayList<CustomerDTO>>(){}.getType());

    }
}
