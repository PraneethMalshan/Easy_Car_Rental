package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "select * from Driver where username=:nm",nativeQuery = true)
    Driver searchDriverWithUserName(@Param("nm") String username);

    @Query(value = "SELECT * FROM Driver WHERE availability=true ORDER BY RAND() LIMIT 1",nativeQuery = true)
    List<Driver> getRandomDriver();

    @Modifying
    @Transactional
    @Query(value = "UPDATE Driver SET availability = false WHERE nic=:nic", nativeQuery = true)
    void updateDriverNonAvailable(@Param("nic") String nic);


}
