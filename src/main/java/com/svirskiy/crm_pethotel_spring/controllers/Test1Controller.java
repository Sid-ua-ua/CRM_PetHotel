package com.svirskiy.crm_pethotel_spring.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class Test1Controller implements FXMLController<String> {

    @FXML
    Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @Override
    public void setParameters(String param) {
        System.out.println(param);
        label.setText(param);
    }
}
