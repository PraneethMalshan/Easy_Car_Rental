package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

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
    private String username;
    private String password;

    private MultipartFile nicFrontImg;
    private MultipartFile nicBackImg;

}
