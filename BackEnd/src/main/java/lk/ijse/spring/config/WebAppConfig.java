package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.AdminController;
import lk.ijse.spring.controller.CarController;
import lk.ijse.spring.controller.CustomerController;
import lk.ijse.spring.controller.DriverController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "lk.ijse.spring")
@ComponentScan(basePackageClasses = {DriverController.class, CustomerController.class, CarController.class, AdminController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10485760);
        resolver.setMaxInMemorySize(1048576);
        return resolver;
    }

}
