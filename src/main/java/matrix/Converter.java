package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

    public List<Integer> convertToList(Integer[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (Integer[] array : matrix) {

            result.addAll(Arrays.asList(array));
        }
        return result;
    }
}
