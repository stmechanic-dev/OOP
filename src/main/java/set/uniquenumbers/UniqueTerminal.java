package set.uniquenumbers;

import java.util.*;

public class UniqueTerminal {


    public Set<Integer> getUniqueNumbersByDesc(int[] numbers) {

        NavigableSet<Integer> result = new TreeSet<>();

        for (int number : numbers) {
            result.add(number);
        }

        return result.descendingSet();
    }
}