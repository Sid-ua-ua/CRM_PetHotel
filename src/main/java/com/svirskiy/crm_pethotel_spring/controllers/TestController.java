package com.svirskiy.crm_pethotel_spring.controllers;

import com.svirskiy.crm_pethotel_spring.model.Cage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

@Controller
public class TestController implements FXMLController<MainMenuController.Person>{
    @FXML
    TableView<Cage> table;

    private final ObservableList<Cage> data =
            FXCollections.observableArrayList(
            );

    @Override
    public void setParameters(MainMenuController.Person param) {
        data.add(new Cage(param.getName(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString()));
        System.out.println(data);
        table.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setItems(data);

        table.getColumns().forEach(column -> {
            PropertyValueFactory propertyValueFactory = new PropertyValueFactory<Cage, String>(column.getId());
            column.setCellValueFactory(propertyValueFactory);
        });
        System.out.println("initialized");
    }
}
