package arrayfunction;

import org.junit.Assert;
import org.junit.Test;

public class ArrayFunctionallyServiceTest {

    private final ArrayFunctionallyService arrayFunctionallyService = new ArrayFunctionallyService();

    @Test
    public void getDetail() {
        ArrayDetail arrayDetail = arrayFunctionallyService.getArrayByCriteria(new int[] {1, 8, 10, 1, 12, 3, 8});
        Assert.assertEquals(1, arrayDetail.getFirstElement());
        Assert.assertEquals(8, arrayDetail.getLastElement());
        Assert.assertEquals(34, arrayDetail.getSumBetweenFirstAndLast());
    }

    @Test
    public void getSumBetweenIndex() {
        int result = arrayFunctionallyService.getSumNumbersBetweenIndex(new int[] {1, 8, 3, 10, 9, 4, 6}, 2, 5);
        Assert.assertEquals(26, result);
    }
}