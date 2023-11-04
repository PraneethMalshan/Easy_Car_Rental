package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    @Query(value = "select * from Customer where username=:nm",nativeQuery = true)
    Customer searchCustomerWithUserName(@Param("nm") String username);


}
