package com.svirskiy.crm_pethotel_spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;

@SpringBootApplication
public class CrmPetHotelSpringApplication {

    public static void main(String[] args) {
        Application.launch(JavafxApplication.class, args);
    }

}
