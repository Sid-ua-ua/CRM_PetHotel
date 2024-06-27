package com.svirskiy.crm_pethotel_spring;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

@org.springframework.context.annotation.Configuration
public class ApplicationConfiguration {

    @Bean
    public FXMLLoader fxmlLoader(ApplicationContext context){
        return new FXMLLoader() {
            @Override
            public <T> T load(InputStream inputStream) throws IOException {
                this.setRoot(null);
                this.setController(null);
                this.setControllerFactory(context::getBean);
                return super.load(inputStream);
            }
        };
    }
}
