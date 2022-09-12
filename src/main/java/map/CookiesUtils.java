package map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookiesUtils {

    private final static String SPEC_SYMBOL = ";";
    private final static String DOUBLE_POINT = ":";

    public static Map<String, Pair> getCookies(List<String> cookiesTestList) {
        Map<String, Pair> result = new HashMap<>();

        for (String string : cookiesTestList) {
            Flag[] flags = identityFlags(string);

            result.put(string.split(DOUBLE_POINT)[0], Pair.of(
                    string.split(DOUBLE_POINT)[0], string.split(DOUBLE_POINT)[1].split(SPEC_SYMBOL)[0], flags));
        }

        return result;
    }

    private static Flag[] identityFlags(String stringWithFlags) {
        Flag[] flags = null;

        if (stringWithFlags.split(SPEC_SYMBOL).length <= 1) {
            flags = new Flag[] {
                    Flag.SECURE,
                    Flag.HTTP_ONLY,
                    Flag.SESSION
            };
        } else if (stringWithFlags.split(SPEC_SYMBOL)[1].equals(Flag.SECURE.name())) {
            flags = new Flag[] {
                    Flag.SECURE,
                    Flag.HTTP_ONLY
            };
        } else if (stringWithFlags.split(SPEC_SYMBOL)[1].equals(Flag.SESSION.name())) {
            flags = new Flag[] {
                    Flag.SESSION,
                    Flag.HTTP_ONLY
            };
        }

        return flags;
    }
}
