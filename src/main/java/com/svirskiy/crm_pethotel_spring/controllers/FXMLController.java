package com.svirskiy.crm_pethotel_spring.controllers;

import javafx.fxml.Initializable;

public interface FXMLController<T> extends Initializable {
    void setParameters(T param);
}
