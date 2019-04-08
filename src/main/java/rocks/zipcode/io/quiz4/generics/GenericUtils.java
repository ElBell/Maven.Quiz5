package rocks.zipcode.io.quiz4.generics;

import java.util.*;

import com.google.common.collect.Sets;


/**
 * @author leon on 11/12/2018.
 */
public class GenericUtils {
    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(Set<_> originalSet) {
        List<Set<_>> sets = new ArrayList<>(Sets.powerSet(originalSet));
        Set<Set<_>> newSets = new LinkedHashSet<>();
        int longest = originalSet.size();
        for (Set<_> set : sets) {
            if (set.size() < longest && set.size() > 1) {
                newSets.add(swapValues(set));
            }
        }
        sets.addAll(newSets);
        Collections.sort(sets, new SortSets<>());
        return sets;
    }

    private static <_ extends Comparable> Set swapValues(Set<_> set) {
        Set<_> newSet = new LinkedHashSet();
        Iterator<_> iterator =  set.iterator();
        _ second = iterator.next();
        _ first = iterator.next();
        newSet.add(first);
        newSet.add(second);
        return newSet;
    }

    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(_... originalSet) {
        return powerSet(new TreeSet<>(Arrays.asList(originalSet)));
    }
}

