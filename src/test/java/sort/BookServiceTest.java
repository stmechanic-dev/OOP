package sort;

import org.junit.Assert;
import org.junit.Test;


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
}