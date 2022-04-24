package com.SKP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class Human implements Serializable {

    private String name;
    private transient int age;

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException{
        stream.defaultWriteObject();
        // zapisuje do strumienia nie wiek a datę urodzenia
        int birthYear = Calendar.getInstance().get(Calendar.YEAR) - age;
        stream.writeInt(birthYear);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int birthYear = stream.readInt();
        age = Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }
}
