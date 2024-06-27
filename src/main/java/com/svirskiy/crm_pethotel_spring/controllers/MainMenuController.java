package com.svirskiy.crm_pethotel_spring.controllers;

import com.svirskiy.crm_pethotel_spring.menu.MenuCategory;
import com.svirskiy.crm_pethotel_spring.menu.MenuItem;
import com.svirskiy.crm_pethotel_spring.services.PaneService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class MainMenuController implements FXMLController<String> {
    @FXML
    private TreeView<MenuItem<?>> treeView;
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView logoutImg;

    private final Image logout;
    private final TreeItem<MenuItem<?>> rootNode;


    private final PaneService paneService;

    List<MenuCategory<?>> menuCategories = Arrays.asList(
            new MenuCategory<>("Працівники", "workers.fxml", Arrays.asList(
                    new MenuItem<>("worker_detail.fxml", new Person("Ethan", "Williams")),
                    new MenuItem<>("worker_detail.fxml", new Person("Emma","Jones")),
                    new MenuItem<>("worker_detail.fxml", new Person("Michael","Brown")),
                    new MenuItem<>("worker_detail.fxml", new Person("Anna","Black")),
                    new MenuItem<>("worker_detail.fxml", new Person("Rodger","York")),
                    new MenuItem<>("worker_detail.fxml", new Person("Susan","Collins"))
            )),
            new MenuCategory<>("Записи на заселення", "Records_list.fxml", Arrays.asList(
                    new MenuItem<>("Record_create.fxml","Додати запис")

            )),
            new MenuCategory<>("Accounts Department", null, Arrays.asList(
                    new MenuItem<>(null,"Jacob Smith"),
                    new MenuItem<>(null,"Isabella Johnson")
            ))
    );



    public MainMenuController(@Value("menu.png") Resource rootIcon,
                              @Value("logout.png") Resource loginImgResource,
                              PaneService paneService) throws IOException {
        Node rootIcon1 = new ImageView(new Image(rootIcon.getInputStream()));
        this.paneService = paneService;
        this.rootNode = new TreeItem<>(new MenuItem<>("root.fxml","MyCompany Menu"), rootIcon1);
        logout = new Image(loginImgResource.getInputStream());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.logoutImg.setImage(logout);
        rootNode.setExpanded(true);
        for (MenuCategory<?> category : menuCategories) {
            TreeItem<MenuItem<?>> depNode = new TreeItem<MenuItem<?>>(category);
             category.getItems().forEach(elem->{
                if (!(elem instanceof MenuItem<?> item)) return;
                TreeItem<MenuItem<?>> itemLeaf = new TreeItem<MenuItem<?>>(item);
                itemLeaf.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
                    System.out.println("Selected Item: " + item.getValue());
                });
                depNode.getChildren().add(itemLeaf);
            });
            rootNode.getChildren().add(depNode);
        }
        treeView.setRoot(rootNode);

        treeView.setOnMouseClicked(e -> {
            if(treeView.getSelectionModel().getSelectedItems().isEmpty()) return;
            MenuItem<?> selected = treeView.getSelectionModel().getSelectedItems().getFirst().getValue();
            if (!pane.getChildren().isEmpty())
                pane.getChildren().removeFirst();
            Node node = paneService.getNode(selected.getFxml());
            AnchorPane.setBottomAnchor(node, 0.0);
            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
            pane.getChildren().add(node);
            paneService.getController(selected.getFxml()).setParameters(selected.getValue());
        });
        System.out.println("hello");
    }

    @Override
    public void setParameters(String param) {

    }





    @Data
    class Person{
        private final String name;
        private final String surname;

        public String toString() {
            return name + " " + surname;
        }
    }
}