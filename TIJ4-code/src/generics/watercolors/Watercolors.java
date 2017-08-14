//: generics/watercolors/Watercolors.java
package generics.watercolors;

public enum Watercolors {
    ZINC(1, "锌"),
    LEMON_YELLOW(2, "柠檬黄"),
    MEDIUM_YELLOW,
    DEEP_YELLOW,
    ORANGE,
    BRILLIANT_RED,
    CRIMSON,
    MAGENTA,
    ROSE_MADDER,
    VIOLET,
    CERULEAN_BLUE_HUE,
    PHTHALO_BLUE,
    ULTRAMARINE,
    COBALT_BLUE_HUE,
    PERMANENT_GREEN,
    VIRIDIAN_HUE,
    SAP_GREEN,
    YELLOW_OCHRE,
    BURNT_SIENNA,
    RAW_UMBER,
    BURNT_UMBER,
    PAYNES_GRAY,
    IVORY_BLACK;

    private Integer ord;
    private String lable;

    private Watercolors() {
    }

    private Watercolors(Integer ord, String lable) {
        this.ord = ord;
        this.lable = lable;
    }

} ///:~
