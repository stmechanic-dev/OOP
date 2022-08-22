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

    @Test
    public void getHash() {
        KeyService keyService = new KeyService();
        String generateKeyFirst = "efb70671-9b0d-4763-a9cf-dd6165a873ee";
        String generateKeySecond = "88e44e41-176f-4caf-94d3-f618caf6147c";
        // 7067190476396165873 + 88444117649436186147 = 706719047639616587388444117649436186147
        Pair pair = Pair.of(generateKeyFirst, generateKeySecond);
        BigInteger result = keyService.getHash(pair);
        BigInteger expected = new BigInteger("706719047639616587388444117649436186147");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getHashWithoutNumbers() {
        KeyService keyService = new KeyService();
        String generateKeyFirst = "asfasffassf";
        String generateKeySecond = "asfasdf";
        Pair pair = Pair.of(generateKeyFirst, generateKeySecond);
        BigInteger result = keyService.getHash(pair);
        Assert.assertEquals(BigInteger.ZERO, result);
    }

    @Test(expected = NullPointerException.class)
    public void whenNull() {
        KeyService keyService = new KeyService();
        Pair pair = Pair.of(null, "sdfsdf");
    }
}