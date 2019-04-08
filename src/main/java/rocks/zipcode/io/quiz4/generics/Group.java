package rocks.zipcode.io.quiz4.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author leon on 18/12/2018.
 */
public class Group<_> implements Iterable<_>, GroupInterface<_>{
    private List<_> elements;
    public Group() {
        elements = new ArrayList<>();
    }

    public Integer count() {
        return elements.size();
    }

    public void insert(_ value) {
        elements.add(value);
    }

    public Boolean has(_ value) {
        return elements.contains(value);
    }

    public _ fetch(int indexOfValue) {
        return elements.get(indexOfValue);
    }

    public void delete(_ value) {
        elements.remove(value);
    }

    public void clear() {
        elements.clear();
    }

    public Iterator<_> iterator() {
        return elements.iterator();
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    public <_ extends Comparable> void sort() {
        Collections.sort((List<_>)elements);
    }

    public Integer indexOf(_ object) {
        return elements.indexOf(object);
    }
}
