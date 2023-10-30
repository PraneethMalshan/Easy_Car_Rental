package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data  //getters setters
@ToString
public class DriverDTO {
    private String driverId;
    private String driverName;
    private String driverTel;
    private String driverEmail;
    private String driverPassword;
    private String driverNicId;
    private String driverLicenceId;
    /*private String driverLicenceImg;
    private String driverNicImg;*/
}
