package rocks.zipcode.io.quiz4.generics;


/**
 * @author leon on 18/12/2018.
 */
public class SortedGroup<_ extends Comparable> extends Group<_> {
    @Override
    public void insert(_ value) {
        super.insert(value);
        super.sort();
    }

    @Override
    public void delete(_ value) {
        super.delete(value);
    }

    public Integer indexOf(_ value) {
        return super.indexOf(value);
    }
}
