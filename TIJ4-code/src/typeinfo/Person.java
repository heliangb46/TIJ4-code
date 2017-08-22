package typeinfo;

import java.util.ArrayList;
import java.util.Collection;

//: typeinfo/Person.java
// A class with a Null Object.
import net.mindview.util.Null;

class Person {
    public final String first;
    public final String last;
    public final String address;

    // etc.
    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {
        private NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    public static final Person NULL = new NullPerson();

    public static void main(String[] args) {
        Person p = Person.NULL;
        Collection<Person> list = new ArrayList<Person>();
        list.add(p);
        System.out.println(p.first);
    }
} ///:~
