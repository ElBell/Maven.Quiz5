package rocks.zipcode.io.quiz4.generics;

import java.util.*;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


/**
 * @author leon on 11/12/2018.
 */
public class GenericUtils {
    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(Set<_> originalSet) {
        _ firstElement = originalSet.iterator().next();
        List<Set<_>> sets = new ArrayList<>(actualPowerSet(originalSet));
        Set<Set<_>> newSets = new LinkedHashSet<>();
        int longest = sets.get(0).size();
        sets = sets.stream().filter(s -> s.size() < longest).collect(Collectors.toList());
        for (Set<_> set : sets) {
            if (set.size() < longest && set.size() > 1) {
                Set newSet = new LinkedHashSet();
                Iterator<_> iterator =  set.iterator();
                _ second = iterator.next();
                _ first = iterator.next();
                newSet.add(first);
                newSet.add(second);
                newSets.add(newSet);
            }
        }
        sets.addAll(newSets);
        sets.add(originalSet);
        Collections.sort(sets, new SortSets<>());
        return sets;
    }

    public static <_ extends Comparable> List<? extends Set<_>> actualPowerSet(Set<_> originalSet) {
        List<Set<_>> sets = new ArrayList<>();
        if (originalSet.isEmpty()) {
            sets.add(new LinkedHashSet<_>());
            return sets;
        }
        List<_> list = new ArrayList<_>(originalSet);
        _ head = list.get(0);
        Set<_> rest = new HashSet<_>(list.subList(1, list.size()));
        for (Iterable<_> set : actualPowerSet(rest)) {
            Set<_> newSet = new LinkedHashSet<_>();
            newSet.add(head);
            newSet.addAll((Collection<? extends _>) set);
            sets.add(newSet);
            sets.add((LinkedHashSet<_>) set);
        }
        return sets;
    }

    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(_... originalSet) {
        return powerSet(new TreeSet<>(Arrays.asList(originalSet)));
    }
}

