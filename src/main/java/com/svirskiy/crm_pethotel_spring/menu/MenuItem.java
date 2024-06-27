package com.svirskiy.crm_pethotel_spring.menu;

import lombok.Data;

@Data
public class MenuItem<T> {

    private final String fxml;
    private final T value;

    public MenuItem(String fxml, T value) {
        this.fxml = fxml;
        this.value = value;
    }

    public String toString() {
        return value.toString();
    }
}
