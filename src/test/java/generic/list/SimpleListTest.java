package generic.list;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;


public class SimpleListTest {

    @Test
    public void whenAddElement() {
        SimpleList<Integer> simpleList = new SimpleList<>(2);

        simpleList.add(2);
        simpleList.add(5);
        simpleList.add(4);
        simpleList.add(12);

        Assertions.assertEquals(4, simpleList.size());
    }

    @Test
    public void whenRemoveElement() {
        SimpleList<Integer> simpleList = new SimpleList<>(2);

        simpleList.add(2);
        simpleList.add(5);
        simpleList.add(10);
        simpleList.add(12);

        simpleList.remove(0);
        List<Integer> expected = List.of(5, 10, 12);

        Assertions.assertEquals(3, simpleList.size());
        Assertions.assertIterableEquals(expected, simpleList);
    }

    @Test
    public void whenSetElement() {
        SimpleList<Integer> simpleList = new SimpleList<>(2);

        simpleList.add(2);
        simpleList.add(5);
        simpleList.add(4);
        simpleList.add(12);

        simpleList.set(2, 10);

        List<Integer> expected = List.of(2, 5, 10, 12);

        Assertions.assertEquals(10, simpleList.get(2));
        Assertions.assertIterableEquals(expected, simpleList);
    }

    @Test
    public void whenCheckIterator() {
        SimpleList<Integer> simpleList = new SimpleList<>(2);

        simpleList.add(2);
        simpleList.add(5);
        simpleList.add(4);
        simpleList.add(12);

        List<Integer> expected = List.of(2, 5, 4, 12);

        Assertions.assertEquals(4, simpleList.size());
        Assertions.assertIterableEquals(expected, simpleList);
    }
}