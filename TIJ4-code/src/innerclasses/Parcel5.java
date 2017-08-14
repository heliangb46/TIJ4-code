package innerclasses;

//: innerclasses/Parcel5.java
// Nesting a class within a method.

public class Parcel5 {

    public Destination destination(String s) {

        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        new Thread(((new MyThread()).getRunner())).start();
    }
} ///:~

class MyThread {
    public Runnable getRunner() {
        class Runner implements Runnable {

            @Override
            public void run() {
                int i = 0;
                while (i < 1000) {
                    System.out.println(i++);
                }
            }
        }
        return new Runner();
    }
}