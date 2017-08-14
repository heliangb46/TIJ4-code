package typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//: typeinfo/RegisteredFactories.java
// Registering Class Factories in the base class.
import typeinfo.factory.Factory;

/*
 * 零件
 */
class Part {
    private static Random rand = new Random(47);

    /*
     * 零件工厂
     */
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();

    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}

/*
 * 过滤器
 */
class Filter extends Part {

}

/*
 * 燃料过滤器
 */
class FuelFilter extends Filter {
    // Create a Class Factory for each specific type:
    public static class Factory implements typeinfo.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

/*
 * 空气滤清器
 */
class AirFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

/*
 * 空调滤清器
 */
class CabinAirFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

/*
 * 机油滤清器
 */
class OilFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

/*
 * 皮带
 */
class Belt extends Part {
}

/*
 * 风扇皮带
 */
class FanBelt extends Belt {
    public static class Factory implements typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

/*
 * 发电机皮带
 */
class GeneratorBelt extends Belt {
    public static class Factory implements typeinfo.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

/*
 * 转向机皮带
 */
class PowerSteeringBelt extends Belt {
    public static class Factory implements typeinfo.factory.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
} /* Output:
  GeneratorBelt
  CabinAirFilter
  GeneratorBelt
  AirFilter
  PowerSteeringBelt
  CabinAirFilter
  FuelFilter
  PowerSteeringBelt
  PowerSteeringBelt
  FuelFilter
  *///:~
