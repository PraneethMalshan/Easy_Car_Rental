package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class CarRent {


    @Id
    private String rentId;
    private String rentType;
    private String pickUpDate;
    private String returnDate;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "nicNo", referencedColumnName = "nicNo")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "registrationNO", referencedColumnName = "registrationNO")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverId", referencedColumnName = "licenceNo")
    private Driver driver;



}
