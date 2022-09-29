package generic.list;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class SimpleUniqueListTest {

    @Test
    public void whenAddElement() {
        SimpleUniqueList<Integer> simpleUniqueList = new SimpleUniqueList<>(2);

        simpleUniqueList.add(2);
        simpleUniqueList.add(5);
        simpleUniqueList.add(4);
        simpleUniqueList.add(12);

        Assertions.assertEquals(4, simpleUniqueList.size());
    }

    @Test
    public void whenRemoveElement() {
        SimpleUniqueList<Integer> simpleUniqueList = new SimpleUniqueList<>(2);

        simpleUniqueList.add(2);
        simpleUniqueList.add(5);
        simpleUniqueList.add(10);
        simpleUniqueList.add(12);

        simpleUniqueList.remove(0);
        List<Integer> expected = List.of(5, 10, 12);

        Assertions.assertEquals(3, simpleUniqueList.size());
        Assertions.assertIterableEquals(expected, simpleUniqueList);
    }

    @Test
    public void whenSetElement() {
        SimpleUniqueList<Integer> simpleUniqueList = new SimpleUniqueList<>(2);

        simpleUniqueList.add(2);
        simpleUniqueList.add(5);
        simpleUniqueList.add(4);
        simpleUniqueList.add(12);

        simpleUniqueList.set(2, 10);

        List<Integer> expected = List.of(2, 5, 10, 12);

        Assertions.assertEquals(10, simpleUniqueList.get(2));
        Assertions.assertIterableEquals(expected, simpleUniqueList);
    }

    @Test
    public void whenCheckIterator() {
        SimpleUniqueList<Integer> simpleUniqueList = new SimpleUniqueList<>(2);

        simpleUniqueList.add(2);
        simpleUniqueList.add(5);
        simpleUniqueList.add(4);
        simpleUniqueList.add(12);

        List<Integer> expected = List.of(2, 5, 4, 12);

        Assertions.assertEquals(4, simpleUniqueList.size());
        Assertions.assertIterableEquals(expected, simpleUniqueList);
    }

    @Test

    public void whenCheckDublicate() {
        SimpleUniqueList<Integer> simpleUniqueList = new SimpleUniqueList<>(2);

        simpleUniqueList.add(2);
        simpleUniqueList.add(3);
        simpleUniqueList.add(4);
        simpleUniqueList.add(2);

        List<Integer> expected = List.of(2, 3, 4);

        Assertions.assertEquals(3, simpleUniqueList.size());
        Assertions.assertIterableEquals(expected, simpleUniqueList);
    }
}