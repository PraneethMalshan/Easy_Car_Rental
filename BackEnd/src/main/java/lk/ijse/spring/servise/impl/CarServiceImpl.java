package lk.ijse.spring.servise.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.servise.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo repo ;

    @Autowired
    private ModelMapper mapper ;

    @Override
    public void saveCar(CarDTO dto) {
        if (repo.existsById(dto.getRegistrationNO())){
            throw new RuntimeException("Customer already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Car.class));
    }

    @Override
    public void deleteCar(String registrationNO) {

    }

    @Override
    public void updateCar(CarDTO dto) {

    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return null;
    }
}
