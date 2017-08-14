package initialization;

//: initialization/Spiciness.java

public enum Spiciness {
    NOT(1, "NOT"), MILD(2, "MILD"), MEDIUM(3, "MEDIUM"), HOT(4, "HOT"), FLAMING(5, "FLAMING");
    int ord;
    String val;

    Spiciness(int ord, String val) {
        this.ord = ord;
        this.val = val;
    }

    public static Spiciness parse(int i) {
        Spiciness result = null;
        switch (i) {
        case 1:
            result = Spiciness.NOT;
            break;
        case 2:
            result = Spiciness.MILD;
            break;
        }
        return result;
    }
} ///:~
