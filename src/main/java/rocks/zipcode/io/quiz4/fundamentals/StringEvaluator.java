package rocks.zipcode.io.quiz4.fundamentals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leon on 11/12/2018.
 */
public class StringEvaluator {
    public static String[] getAllSubstrings(String string) {
        Set<String> subStrings = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                String currentSubstring = string.substring(i,j);
                subStrings.add(currentSubstring);
            }
        }
        return subStrings.toArray(new String[0]);
    }

    public static String[] getCommonSubstrings(String string1, String string2) {
        return Arrays.stream(getAllSubstrings(string2))
                .filter(s -> isIn(s, getAllSubstrings(string1)))
                .toArray(String[]::new);
    }
    public static boolean isIn(String element, String[] array){
        return Arrays.asList(array).contains(element);
    }

    public static String getLargestCommonSubstring(String string1, String string2) {
        return Arrays.stream(getAllSubstrings(string2))
                .filter(s -> isIn(s, getAllSubstrings(string1)))
                .sorted((s1, s2) -> s2.length()-s1.length())
                .toArray(String[]::new)[0];
    }
}
