package com.SKP;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DieselEngine extends Engine {


    public DieselEngine(String model) {
        super(model);
    }

    private void writeObject(ObjectOutputStream out) throws NotSerializableException {
        throw new NotSerializableException("Silnik disela nie jest serializowalny!");

    }

    private void readObject(ObjectInputStream in) throws NotSerializableException {
        throw new NotSerializableException("Silnik disela nie jest serializowalny!");
    }
}
