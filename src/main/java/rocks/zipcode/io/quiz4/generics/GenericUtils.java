package rocks.zipcode.io.quiz4.generics;

import java.util.*;
import java.util.stream.Collectors;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;


/**
 * @author leon on 11/12/2018.
 */
public class GenericUtils {
    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(Set<_> originalSet) {
        List<Set<_>> sets = new ArrayList<Set<_>>(Sets.powerSet(originalSet)) {{ remove(originalSet); }};
        List<Set<_>> newSets = new ArrayList<>(Arrays.asList(originalSet));
        sets.forEach(set -> Collections2.permutations(set).forEach(s -> newSets.add(new LinkedHashSet<>(s))));
        Collections.sort(newSets, new SortSets<>());
        return newSets;
    }

    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(_... originalSet) {
        return powerSet(new TreeSet<>(Arrays.asList(originalSet)));
    }
}

