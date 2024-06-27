package com.svirskiy.crm_pethotel_spring.services;

import com.svirskiy.crm_pethotel_spring.controllers.FXMLController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaneServiceImpl implements PaneService {
    private final Map<String, Node> panes;
    private final Map<String, FXMLController<?>> controllers;
    private final FXMLLoader loader;
    private final ResourceLoader resourceLoader;

    public PaneServiceImpl(FXMLLoader loader, ResourceLoader resourceLoader) {
        this.loader = loader;
        this.resourceLoader = resourceLoader;
        this.panes = new HashMap<>();
        this.controllers = new HashMap<>();
    }

    @Override
    public Node getNode(String name) {
        return panes.computeIfAbsent(name, this::loadNode);
    }

    @Override
    public FXMLController<?> getController(String name) {
        return controllers.get(name);
    }

    private Node loadNode(String name) {
        try {
            Resource fxml = resourceLoader.getResource("classpath:" + name);
            Node node = loader.load(fxml.getInputStream());
            this.controllers.put(name, loader.getController());
            return node;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
