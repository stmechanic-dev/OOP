package pair;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class KeyServiceTest {

    @Test
    public void correctTest() {
        KeyService keyService = new KeyService();
        Pair pair = Pair.of("kj;adshf1hjk4", "lkjahsfdlj6kjh7");
        BigInteger expected = BigInteger.valueOf(1467);

        Assert.assertEquals(expected, keyService.getHash(pair));
    }

    @Test (expected = NullPointerException.class)
    public void whenCreatePairExeption() {
        Pair.of("hafdkjhjkhdf4", null);
    }
}