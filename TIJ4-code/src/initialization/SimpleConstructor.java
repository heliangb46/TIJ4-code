
// : initialization/SimpleConstructor.java
// Demonstration of a simple constructor.

public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new Rock();
    }
}

class Rock {
    Rock() { // This is the constructor
        System.out.print("Rock ");
    }
}

/*
 * Output: Rock Rock Rock Rock Rock Rock Rock Rock Rock Rock
 */// :~
