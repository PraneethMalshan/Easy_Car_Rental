package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer {
    @Id
    private String nicNo;
    private String name;
    private String address;
    private int contactNo;
    private String email;
    private String nicFrontImg;
    private String licenceNo;
    private String licenceImg;
    private String username;
    private String password;

}
