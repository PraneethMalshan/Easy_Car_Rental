package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data  //getters setters
@ToString
public class CustomerDTO {
    private String nicNo;
    private String licenceNo;
    private String name;
    private String address;
    private int contactNo;
    private String email;
    private String nicFrontImg;
    private String licenceImg;
    private String username;
    private String password;
}
