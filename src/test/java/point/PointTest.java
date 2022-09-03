package point;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void correctCalculate() {
        Point firstPoint = new Point(1, 7);
        Point secondPoint = new Point(14, 29);

        double result = firstPoint.distance(secondPoint);
        double expexted = 25.55386467836128;

        Assert.assertEquals(expexted, result, 0.01);
    }

}