package lk.ijse.spring.servise;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CarService {
    public void saveCar(CarDTO dto );
    public void deleteCar(String registrationNO);
    public void updateCar(CarDTO dto);
    public ArrayList<CarDTO> getAllCars();
}
