package generics;

//: generics/SelfBoundingAndCovariantArguments.java

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        // s1.set(sbs); // Error:
        sbs.set(new SelfBoundSetter() {

            @Override
            public void set(SelfBoundSetter arg) {
                // TODO Auto-generated method stub

            }

        });
        s1.set(new Setter() {

            @Override
            public void set(Setter arg) {
                // TODO Auto-generated method stub

            }
        });// in SelfBoundSetter<Setter>
           // cannot be applied to (SelfBoundSetter)
    }
} ///:~
