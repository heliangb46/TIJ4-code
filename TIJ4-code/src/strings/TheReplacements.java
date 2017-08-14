package strings;

import static net.mindview.util.Print.print;

//: strings/TheReplacements.java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/

public class TheReplacements {
    public static void main(String[] args) throws Exception {
        String s = TextFile.read("src//strings//TheReplacements.java");
        // Match the specially commented block of text above:
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find()) {// Captured by parentheses
            s = mInput.group(1);
        }
        print(s);
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        print(s);
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        print(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        print(s);
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // Put in the remainder of the text:
        m.appendTail(sbuf);
        print(sbuf);
    }
} /* Output:
  Here's a block of text to use as input to
  the regular expression matcher. Note that we'll
  first extract the block of text by looking for
  the special delimiters, then process the
  extracted block.
  H(VOWEL1)rE's A blOck Of tExt tO UsE As InpUt tO
  thE rEgUlAr ExprEssIOn mAtchEr. NOtE thAt wE'll
  fIrst ExtrAct thE blOck Of tExt by lOOkIng fOr
  thE spEcIAl dElImItErs, thEn prOcEss thE
  ExtrActEd blOck.
  *///:~