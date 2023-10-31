package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.CustomerController;
import lk.ijse.spring.controller.DriverController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "lk.ijse.spring")
@ComponentScan(basePackageClasses = {DriverController.class, CustomerController.class, AppWideExceptionHandler.class})
public class WebAppConfig {


  /*  public WebAppConfig() {
//        System.out.println("WebAppConfig: Instantiated");
    }*/
}
