package reusing;

//: reusing/BlankFinal.java
// "Blank" final fields.

class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

/**
 * @category final
 * 空白的final，必须初始化后才能编译通过
 *
 */
public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference
    // Blank finals MUST be initialized in the constructor:

    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
} ///:~
