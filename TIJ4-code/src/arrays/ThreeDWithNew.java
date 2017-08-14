package arrays;

//: arrays/ThreeDWithNew.java
import java.util.Arrays;

public class ThreeDWithNew {
    public static void main(String[] args) {
        // 3-D array with fixed length:
        int[][][] a = new int[2][2][4];
        a[0][0][1] = 1;
        a[0][1][1] = 1;
        a[1][1][1] = 1;
        System.out.println(Arrays.deepToString(a));
    }
} /* Output:
  [[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
  *///:~
