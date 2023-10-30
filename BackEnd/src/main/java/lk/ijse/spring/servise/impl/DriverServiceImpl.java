package lk.ijse.spring.servise.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.servise.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper ;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (repo.existsById(dto.getLicenceNo())){
            throw new RuntimeException("Driver already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void deleteDriver(String licenceNo) {
        if (!repo.existsById(licenceNo)){
            throw new RuntimeException("Wrong Licence No. Please enter valid Licence No..");
        }
        repo.deleteById(licenceNo);
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getLicenceNo())){
            throw new RuntimeException("Driver Not Exists.. Please enter Valid Licence No..!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }
}
