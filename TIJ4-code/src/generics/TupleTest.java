package generics;

//: generics/TupleTest.java
import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

class Amphibian {
}

class Vehicle {
}

public class TupleTest {
    static TwoTuple<String, Integer> getATwoTuple() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<String, Integer>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> getAThreeTuple() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> getAFourTuple() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> getAFiveTuple() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = getATwoTuple();
        System.out.println(ttsi);
        // ttsi.first = "there"; // Compile error: final
        System.out.println(getAThreeTuple());
        System.out.println(getAFourTuple());
        System.out.println(getAFiveTuple());
    }
} /* Output: (80% match)
  (hi, 47)
  (Amphibian@1f6a7b9, hi, 47)
  (Vehicle@35ce36, Amphibian@757aef, hi, 47)
  (Vehicle@9cab16, Amphibian@1a46e30, hi, 47, 11.1)
  *///:~
