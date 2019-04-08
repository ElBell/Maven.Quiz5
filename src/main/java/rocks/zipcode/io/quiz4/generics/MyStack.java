package rocks.zipcode.io.quiz4.generics;


import java.util.*;

/**
 * @author leon on 11/12/2018.
 */
public class MyStack<SomeType> implements Iterable<SomeType>{
    private List<SomeType> elements;

    public MyStack() {
        elements = new ArrayList<>();
    }

    public Boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(SomeType i) {
        elements.add(i);
    }

    public SomeType peek() {
        if(isEmpty()){return null;}
        return elements.get(elements.size()-1);
    }

    public SomeType pop() {
        if(isEmpty()) { throw new EmptyStackException(); }
        return elements.remove(elements.size()-1);
    }

    @Override
    public Iterator<SomeType> iterator() {
        return elements.iterator();
    }
}
