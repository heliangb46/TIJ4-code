package interfaces;

//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

/**
 * 怪物
 */
interface Monster {
    /**
     * 恐吓
     */
    void menace();
}

/**
 * 危险怪物
 */
interface DangerousMonster extends Monster {
    /**
     * 摧毁
     */
    void destroy();
}

/**
 * 有杀伤力的
 */
interface Lethal {
    /**
     * 杀
     */
    void kill();
}

/**
 * 吉米拉
 */
class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {
    }

    @Override
    public void destroy() {
    }
}

/**
 * 吸血鬼
 */
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

/**
 * 恶魔吸血鬼
 */
class VeryBadVampire implements Vampire {
    @Override
    public void menace() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void kill() {
    }

    @Override
    public void drinkBlood() {
    }
}

/**
 * 恐怖片
 */
public class HorrorShow {
    static void menaceGo(Monster b) {
        b.menace();
    }

    static void destroyGo(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void makeDeaded(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        menaceGo(barney);
        destroyGo(barney);
        Vampire vlad = new VeryBadVampire();
        menaceGo(vlad);
        destroyGo(vlad);
        makeDeaded(vlad);
    }
} ///:~
