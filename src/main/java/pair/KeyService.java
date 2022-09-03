package pair;

import java.math.BigInteger;

public class KeyService {

    private final char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /*
    В данной задаче нужно разобраться
    1. Как объединить две строки в одну.
    2. Как работает класс StringBuilder , он понадобиться для решения.
    3. Для чего понадобиться метод contains, его нужно переиспользовать.
    4. Как создать значение внутри BigInteger.
     */

    /**
     * Метод берет два ключа, отбирает из этих ключей только цифры, образуя из них значение
     * объединяет 1-ый ключ с 2-ым в огромное число и возвращает его.
     * @param pair пара ключей
     * @return значение
     */
    public BigInteger getHash(Pair pair) {

        String numbersString = findNumbers(pair.getFirstKey() + pair.getSecondKey());

        if (numbersString.length() != 0) {
            return new BigInteger(numbersString);
        }

        return BigInteger.ZERO;
    }

    /**
     * Этот метод сравнивает сопоставление переданных символов с массивом символов(цифр)
     * @param element - передаем символ для сравнения
     * @return - возвращает true сли сопоставление найдено
     */
    private boolean contains(char element) {
        for (char number : numbers) {
            if (number == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Этот метод возвращает строку с необходимыми нам параметрами символов - цифр
     * @param string - входящий параметр строки
     * @return возвращает объект StringBuilder, составленный из искомых символов - цифр
     */
    private String findNumbers(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char simbol : string.toCharArray()) {
            if (contains(simbol)) {
                stringBuilder.append(simbol);
            }
        }

        return String.valueOf(stringBuilder);
    }
}
