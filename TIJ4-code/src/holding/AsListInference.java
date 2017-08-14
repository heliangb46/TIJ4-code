package holding;

//: holding/AsListInference.java
// Arrays.asList() makes its best guess about type.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 雪花
 */
class Snow {
}

/**
 * 粉末
 */
class Powder extends Snow {
}

/**
 * 轻盈
 */
class Light extends Powder {
}

/**
 * 沉重
 */
class Heavy extends Powder {
}

/**
 * 坚硬
 */
class Crusty extends Snow {
}

/**
 * 烂泥
 */
class Slush extends Snow {
}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());

        // Won't compile:
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        // Compiler says:
        // found   : java.util.List<Powder>
        // required: java.util.List<Snow>

        //         Collections.addAll() doesn't get confused:
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        // Give a hint using an
        // explicit type argument specification:
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
        //        snow4.add(new Crusty());
    }
} ///:~
