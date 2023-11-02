package lk.ijse.spring.config;

import lk.ijse.spring.servise.impl.AdminServiceImpl;
import lk.ijse.spring.servise.impl.CarServiceImpl;
import lk.ijse.spring.servise.impl.CustomerServiceImpl;
import lk.ijse.spring.servise.impl.DriverServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {DriverServiceImpl.class, CustomerServiceImpl.class, CarServiceImpl.class, AdminServiceImpl.class})
public class WebRootConfig {

    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper();
    }
}
