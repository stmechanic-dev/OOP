package pair;

import java.util.Objects;

public class Pair {

    private String firstKey;

    private String secondKey;

    private Pair(String firstKey, String secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public static Pair of(String firstKey, String secondKey) {
        if (Objects.isNull(firstKey) || Objects.isNull(secondKey)) {
            throw new NullPointerException();
        }
        return new Pair(firstKey, secondKey);
    }

    public String getFirstKey() {
        return firstKey;
    }

    public String getSecondKey() {
        return secondKey;
    }
}
