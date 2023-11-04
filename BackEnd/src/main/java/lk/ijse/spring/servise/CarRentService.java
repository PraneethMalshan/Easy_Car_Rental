package lk.ijse.spring.servise;

import lk.ijse.spring.entity.CarRent;

public interface CarRentService {
    String generateRentId();
    void saveCarRent(CarRent dto);
}
