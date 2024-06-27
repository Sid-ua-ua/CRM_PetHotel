package com.svirskiy.crm_pethotel_spring.menu;

import com.svirskiy.crm_pethotel_spring.controllers.MainMenuController;
import lombok.Getter;

import java.util.List;

public class MenuCategory<T> extends MenuItem<T> {

    @Getter
    private final List<MenuItem<?>> items;

    public MenuCategory(T value, String fxml, List<MenuItem<?>> items) {
        super(fxml, value);
        this.items = items;
    }

}
