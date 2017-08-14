package initialization;

//: initialization/OverloadingVarargs2.java
// {CompileTimeError} (Won't compile)

public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(Character... args) {
        System.out.print("second0");
    }

    static void f(Character args, Character args1) {
        System.out.print("second1");
    }

    public static void main(String[] args) {
        f(1, 'a');
        f('a', 'b');
    }
} ///:~
