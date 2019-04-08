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
        List<Set<_>> sets = new ArrayList<>(Sets.powerSet(originalSet));
        List<Set<_>> newSets = new ArrayList<>();
        for (Set<_> set : sets) {
            if (set.size() < originalSet.size()) {
                Collections2.permutations(set).forEach(s -> newSets.add(new LinkedHashSet<>(s)));
            }
        }
        newSets.forEach(s -> sets.add(new HashSet<>(s)));
        newSets.add(originalSet);
        Collections.sort(newSets, new SortSets<>());
        return newSets;
    }

    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(_... originalSet) {
        return powerSet(new TreeSet<>(Arrays.asList(originalSet)));
    }
}

