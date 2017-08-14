package reusing;

//: reusing/PlaceSetting.java
// Combining composition & inheritance.
import static net.mindview.util.Print.print;

/**
 * 碟子
 *
 */
class Plate {
    Plate(int i) {
        print("Plate constructor");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        print("DinnerPlate constructor");
    }
}

/**
 * 器皿
 */
class Utensil {
    Utensil(int i) {
        print("Utensil constructor");
    }
}

/**
 * 勺子
 */
class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        print("Spoon constructor");
    }
}

/**
 * 叉子
 */
class Fork extends Utensil {
    Fork(int i) {
        super(i);
        print("Fork constructor");
    }
}

/**
 * 刀
 */
class Knife extends Utensil {
    Knife(int i) {
        super(i);
        print("Knife constructor");
    }
}

// A cultural way of doing something:
class Custom {
    Custom(int i) {
        print("Custom constructor");
    }
}

public class PlaceSetting extends Custom {
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        print("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
} /* Output:
  Custom constructor
  Utensil constructor
  Spoon constructor
  Utensil constructor
  Fork constructor
  Utensil constructor
  Knife constructor
  Plate constructor
  DinnerPlate constructor
  PlaceSetting constructor
  *///:~
