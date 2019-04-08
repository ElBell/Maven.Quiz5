package rocks.zipcode.io.quiz4.generics;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class SortSets<T extends Comparable> implements Comparator<Set<T>> {
    @Override
    public int compare(Set<T> o1, Set<T> o2) {
        Iterator<T> iterator1 = o1.iterator();
        Iterator<T> iterator2 = o2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            int comparison = iterator1.next().compareTo(iterator2.next());
            if (comparison != 0) {
                return comparison;
            }
        }
        if (o1.size() - o2.size() != 0) {
            return o2.size() - o1.size();
        }
        return 0;
    }
}
