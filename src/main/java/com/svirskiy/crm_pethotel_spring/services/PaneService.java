package com.svirskiy.crm_pethotel_spring.services;

import com.svirskiy.crm_pethotel_spring.controllers.FXMLController;
import javafx.scene.Node;

public interface PaneService {
    Node getNode(String name);
    FXMLController getController(String name);
}
