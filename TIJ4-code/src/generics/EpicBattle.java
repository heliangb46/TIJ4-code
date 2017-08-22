package generics;

//: generics/EpicBattle.java
// Demonstrating bounds in Java generics.
import java.util.List;

interface SuperPower {
}

/*
 * 激光眼
 */
interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

/*
 * 顺风耳
 */
interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}

/*
 * 超级嗅觉
 */
interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;

    SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}

/*
 * 超级侦查（犬）
 */
class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
    SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}

/*
 * 利爪
 */
class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {
    CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void hearSubtleNoises() {
    }

    @Override
    public void trackBySmell() {
    }
}

/*
 * 狗孩儿
 */
class DogBoy extends CanineHero<SuperHearSmell> {
    DogBoy() {
        super(new SuperHearSmell());
    }
}

/*
 * 终极战役
 */
public class EpicBattle {
    // Bounds in generic methods:
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);
        // You can do this:
        List<? extends SuperHearing> audioBoys;
        // But you can't do this:
        // List<? extends SuperHearing & SuperSmell> dogBoys;
    }
} ///:~
