package com.SKP;

import java.io.Serializable;

public class Tyre implements Serializable {
    private int size;
    private boolean isFlat;

    public Tyre(int size) {
        this.size = size;
        this.isFlat = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean flat) {
        isFlat = flat;
    }
}
