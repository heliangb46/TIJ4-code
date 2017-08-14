package polymorphism;

//: polymorphism/CovariantReturn.java

/**
 *谷物
 */
class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

/**
 * 小麦
 */
class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

/**
 * 磨
 */
class Mill {
    Grain process() {
        return new Grain();
    }
}

/**
 * 小麦磨
 */
class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
} /* Output:
  Grain
  Wheat
  *///:~
