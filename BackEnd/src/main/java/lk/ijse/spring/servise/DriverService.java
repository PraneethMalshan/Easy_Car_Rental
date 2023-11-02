package lk.ijse.spring.servise;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    void getDriver(DriverDTO dto);
    public void saveDriver(DriverDTO dto);
    public void deleteDriver(String licenceNo);
    public void updateDriver(DriverDTO dto);
    public ArrayList<DriverDTO> getAllDrivers();
}
