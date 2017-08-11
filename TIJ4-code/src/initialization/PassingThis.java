package initialization;

// : initialization/PassingThis.java

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy " + peeled);
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        // ... remove peel
        apple.hasPeel = false;
        return apple; // Peeled
    }
}

class Apple {
    boolean hasPeel = true;// 有皮的苹果

    Apple getPeeled() {
        return Peeler.peel(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "::peel = " + hasPeel;
    }

}

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
} /*
   * Output: Yummy
   */// :~
