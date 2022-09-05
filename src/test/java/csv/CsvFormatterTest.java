package csv;

import org.junit.Assert;
import org.junit.Test;

public class CsvFormatterTest {

    @Test
    public void createArrayPersonFromCsvFile() {
        CsvText csvText = new CsvText();
        CsvFormatter csvFormatter = new CsvFormatter();

        Person[] expected = {
                new Person("Polina", "Obromova"),
                new Person("Vlad", "Morozov"),
                new Person("Arina", "Belinskaya"),
                new Person("Nikita", "Nesterenko"),
        };

        Assert.assertArrayEquals(expected, csvFormatter.getPersonsFromCsvFile(csvText.getTextFromFile()));
    }
}