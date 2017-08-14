package strings;

import static net.mindview.util.Print.printnb;

//: strings/Finding.java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        while (matcher.find()) {
            printnb(matcher.group() + " " + matcher.end() + " ");
        }
        //        print();
        //        int i = 0;
        //        while (matcher.find(i)) {
        //            System.out.println(matcher.group() + " " + matcher.groupCount());
        //            i++;
        //        }
    }
} /* Output:
  Evening is full of the linnet s wings
  Evening vening ening ning ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s
  *///:~
