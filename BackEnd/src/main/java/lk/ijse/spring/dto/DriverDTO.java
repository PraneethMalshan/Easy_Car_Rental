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

    private String licenceNo;
    private String nic;
    private String name;
    private String address;
    private String contactNo;
    private String username;
    private String password;
    private boolean availability;
}
