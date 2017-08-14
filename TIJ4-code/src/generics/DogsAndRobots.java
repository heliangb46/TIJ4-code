package generics;

import static net.mindview.util.Print.print;

//: generics/DogsAndRobots.java
// No latent typing in Java
import typeinfo.pets.Dog;

/**
 * 表演狗
 */
class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        print("Woof!");
    }

    @Override
    public void sit() {
        print("Sitting");
    }

    public void reproduce() {
    }
}

class Robot implements Performs {
    @Override
    public void speak() {
        print("Click!");
    }

    @Override
    public void sit() {
        print("Clank!");
    }

    public void oilChange() {
    }
}

class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
} /* Output:
  Woof!
  Sitting
  Click!
  Clank!
  *///:~