package com.SKP;

import java.io.Serializable;

public class Car implements Serializable {

    private Engine engine;
    private Tyre[] tyres;

    public Car(Engine engine, Tyre[] tyres) {
        this.engine = engine;
        this.tyres = tyres;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Tyre[] getTyres() {
        return tyres;
    }

    public void setTyres(Tyre[] tyres) {
        this.tyres = tyres;
    }
}
