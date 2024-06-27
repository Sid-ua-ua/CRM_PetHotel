package com.svirskiy.crm_pethotel_spring;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

public class StageReadyEvent extends ApplicationEvent {

    public Stage getStage() {
        return (Stage) getSource();
    }
    public StageReadyEvent(Stage source) {
        super(source);
    }
}
