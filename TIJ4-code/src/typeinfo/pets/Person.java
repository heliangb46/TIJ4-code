//: typeinfo/pets/Person.java
package typeinfo.pets;

/**
 * 人类
 */
public class Person extends Individual implements Human {
    public Person(String name) {
        super(name);
    }

    @Override
    public void sayType() {
        System.out.println("I`m a Person");
    }
} ///:~
