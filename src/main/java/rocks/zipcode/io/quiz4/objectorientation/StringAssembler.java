package rocks.zipcode.io.quiz4.objectorientation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leon on 11/12/2018.
 */
public class StringAssembler {
    private List<Character> value;
    private Character delimeter;
    public StringAssembler(Character delimeter) {
        value = new ArrayList<>();
        this.delimeter = delimeter;
    }

    public StringAssembler append(String str) {
        for (char c : str.toCharArray()) {
            value.add(c);
        }
        value.add(delimeter);
        return this;
    }

    public String assemble() {
        String result = value.stream().map(String::valueOf).collect(Collectors.joining());
        return result.substring(0, result.length()-1);
    }
}
