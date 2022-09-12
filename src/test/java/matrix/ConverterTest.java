package matrix;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ConverterTest {

    @Test
    public void whenCoverterIsCorrect() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Converter converter = new Converter();

        List<Integer> result = converter.convertToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Assert.assertEquals(expected, result);
    }

}