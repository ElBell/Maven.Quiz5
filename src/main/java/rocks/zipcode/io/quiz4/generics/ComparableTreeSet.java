package rocks.zipcode.io.quiz4.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author leon on 11/12/2018.
 */
public class ComparableTreeSet<_ extends Comparable> extends TreeSet<_> implements Comparable<ComparableTreeSet<_>>{

    private Set<_> elements = new TreeSet<>();
    public ComparableTreeSet(_... arr) {
        elements.addAll(Arrays.asList(arr));
    }

    public ComparableTreeSet() {

    }

    public int compareTo(ComparableTreeSet<_> o) {
        SortSets sortSets = new SortSets();
        System.out.println(elements);
        System.out.println(o.getElements());
        return sortSets.compare(elements, o.getElements());
    }

    public Set<_> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
