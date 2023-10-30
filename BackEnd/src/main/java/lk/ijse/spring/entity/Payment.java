package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Payment {
    @Id
    private String rentId;
    private String nicNo;
    private double advance;
    private double timeCost;
    private double extraKm;
    private double damage;
    private double total;

}
