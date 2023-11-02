package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "select * from Driver where username=:nm",nativeQuery = true)
    Driver searchDriverWithUserName(@Param("nm") String username);
}
