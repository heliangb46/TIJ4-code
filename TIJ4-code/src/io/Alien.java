package io;

//: io/Alien.java
// A serializable class.
import java.io.Serializable;

public class Alien implements Serializable {
    private String name = "alien";

    @Override
    public String toString() {
        return super.toString() + "name : " + name;
    }
} ///:~
