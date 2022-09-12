package sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;


public class BookServiceTest {

    @Test
    public void whenSortBooksByYear() {
        Book onegin = new Book("Evgeniy Onegin", 1936);
        Book pushkin = new Book("Aleksandr Pushkin", 1985);
        Book gogol = new Book("Nikolay Gogol", 1953);
        Book lermontov = new Book("Mihail Lermontov", 1971);

        BookService bookService = new BookService();
        Book[] sortedBooks = bookService.sortBookByYear(new Book[]{onegin, pushkin, gogol, lermontov});
        Book[] expected = {onegin, gogol, lermontov, pushkin};

        Assert.assertArrayEquals(
                expected,
                sortedBooks
        );
    }

    @Test
    public void whenSortBooksByYearOther() {
        Book onegin = new Book("Evgeniy Onegin", 1964);
        Book pushkin = new Book("Aleksandr Pushkin", 1925);
        Book gogol = new Book("Nikolay Gogol", 1912);
        Book lermontov = new Book("Mihail Lermontov", 1922);
        Book moot = new Book("Moot Dorgovich", 1911);

        BookService bookService = new BookService();
        Book[] sortedBooks = bookService.sortBookByYear(new Book[]{onegin, pushkin, gogol, lermontov, moot});
        Book[] expected = {moot, gogol, lermontov, pushkin, onegin};

        System.out.println(Arrays.toString(sortedBooks));
        Assertions.assertArrayEquals(
                expected,
                sortedBooks
        );
    }
}