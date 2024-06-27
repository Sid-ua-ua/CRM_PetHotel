package com.svirskiy.crm_pethotel_spring;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {
    private final Resource fxml;
    private final FXMLLoader fxmlLoader;

    public StageListener(@Value("classpath:/ui.fxml") Resource fxml, FXMLLoader fxmlLoader) {
        this.fxml = fxml;
        this.fxmlLoader = fxmlLoader;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            Stage stage = event.getStage();
            InputStream stream = this.fxml.getInputStream();
            Scene scene = new Scene(fxmlLoader.load(stream));
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
