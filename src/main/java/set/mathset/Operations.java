package set.mathset;

import java.util.HashSet;
import java.util.Set;

/**
 * Выполняет операции с множествами
 */
public class Operations {

    /**
     * Пересечение множеств
     */
    public Set<Integer> intersection(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> result = new HashSet<>();

        for (Integer number1 : firstSet) {
            for (Integer number2 : secondSet) {
                if (number1 == number2) {
                    result.add(number1);
                }
            }
        }

        return result;
    }

    /**
     * Симметричная разность множеств
     */
    public Set<Integer> simmetricalDifference(Set<Integer> firstSet, Set<Integer> secondSet) {

        Set<Integer> result = new HashSet<>();

        result.addAll(subtract(firstSet,secondSet));
        result.addAll(subtract(secondSet,firstSet));

        return result;
    }

    /**
     * Объединение множеств
     */
    public Set<Integer> union(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> result = new HashSet<>(firstSet);
        result.addAll(secondSet);
        return result;
    }

    /**
     * Разность множеств
     */
    public Set<Integer> subtract(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> result = new HashSet<>();

        for (Integer number1 : firstSet) {
            if (!secondSet.contains(number1)) {
                result.add(number1);
            }
        }

        return result;
    }
}
