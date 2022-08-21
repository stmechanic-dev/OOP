package point;

import org.junit.Assert;
import org.junit.Test;


public class PointServiceTest {

    @Test
    public void correctCalculate() {
        PointService pointService = new PointService();
        Point firstPoint = new Point(1, 7);
        Point secondPoint = new Point(14, 29);

        double result = pointService.distance(firstPoint, secondPoint);
        double expexted = 25.55386467836128;

        Assert.assertEquals(expexted, result, 0.01);
    }

}