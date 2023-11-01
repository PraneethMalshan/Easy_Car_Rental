package lk.ijse.spring.dto;

import lk.ijse.spring.entity.CarImg;
import lk.ijse.spring.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {

    private String registrationNO;
    private String brand;
    private String type;
    private int passengersCount;
    private String transmissionType;
    private String fuelType;
    private String color;
    private double completeKm;
    private String status;
    private CarImg images;
    private Price price;

}
