package csv;

public class CsvFormatter {

    private final String DELIMITER_PERSONS = ";";
    private final String DELIMITER_FIELD = ",";
    private final String DELIMITER_KEY_VALUE = "=";
    private final int LIMIT = 2;

    /**
     * Данный метод принимает строку представленную в формате csv
     * и возвращает массив объектов по параметрам.
     * считается что строка передается в правильном формате.
     * @param csvString строка csv
     */
    public Person[] getPersonsFromCsvFile(String csvString) {

        String[] personsString = csvString.split(DELIMITER_PERSONS);
        Person[] persons = new Person[personsString.length];

        int index = 0;
        for (int i = persons.length - 1; i >= 0; i--) {
            persons[index++] = new Person(
                    personsString[i].split(DELIMITER_KEY_VALUE)[1].split(DELIMITER_FIELD)[0],
                    personsString[i].split(DELIMITER_FIELD)[1].split(DELIMITER_KEY_VALUE)[1]);
        }

        return persons;
    }
}
