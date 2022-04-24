package com.SKP;

import java.io.Serializable;

public class Engine implements Serializable {

    private String model;

    public Engine(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
