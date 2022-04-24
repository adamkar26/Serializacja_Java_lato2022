package com.SKP;

import java.io.*;

public class Main {




    public static void main(String[] args) {
        try {
            //simpleSerialization();
            //carSerialization();
            humanSerialization();
            //staticSer();
            customSerialization();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    private static void simpleSerialization() throws IOException, ClassNotFoundException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("objects.bin"))) {
            outputStream.writeObject(Integer.valueOf(1));
            outputStream.writeObject(Integer.valueOf(2));
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("objects.bin"))) {
            Integer number = (Integer) inputStream.readObject();
            System.out.println(number);
            number = (Integer) inputStream.readObject();
            System.out.println(number);
        }
    }

    private static void carSerialization() throws IOException, ClassNotFoundException {
        // opony
        Tyre[] tyres = new Tyre[] {
                new Tyre(16), new Tyre(16), new Tyre(16), new Tyre(16)
        };
        // silnik
       Engine engine = new Engine("2.0 HDI");
       // wylaczenie serializacji
       // Engine engine = new DieselEngine("2.0 HDI");
        Car car = new Car(engine, tyres);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("cars.bin"))){
            outputStream.writeObject(car);
        }

        //odczyt strumienia
        Car deserializedCar = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("cars.bin"))){
            deserializedCar = (Car) inputStream.readObject();
            System.out.println(deserializedCar.getEngine().getModel());
            System.out.println(deserializedCar.getTyres().length);
        }

        System.out.println(deserializedCar == car);
    }

    private static void humanSerialization() throws IOException, ClassNotFoundException {
        Human human = new Human("Janek", 23);
        try(ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream("human.bin"))) {
            outputStream.writeObject(human);
        }

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("human.bin"))) {
            Human readHuman = (Human) inputStream.readObject();
            System.out.println(readHuman.getName());
            System.out.println(readHuman.getAge());
        }
    }

    private static void staticSer() throws IOException,ClassNotFoundException {
        StaticSerialization object = new StaticSerialization();
        object.filed = 200;
        object.field2 = 300;

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("o.bin"))){
            outputStream.writeObject(object);
        }

        StaticSerialization.filed = 500;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("o.bin"))){
            StaticSerialization  s = (StaticSerialization) inputStream.readObject();
            System.out.println(s.filed);
        }
    }

    private static void customSerialization() throws IOException, ClassNotFoundException {
        CustomSerialization customSerialization = new CustomSerialization(100,"tekst");
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("custom.bin"))){
            outputStream.writeObject(customSerialization);
        }

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("custom.bin"))){
            CustomSerialization custom  = (CustomSerialization) inputStream.readObject();
            System.out.println(custom.getSomeField());
            System.out.println(custom.getOtherField());

        }
    }
}
