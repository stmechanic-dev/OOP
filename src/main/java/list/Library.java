package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Library implements StoreBook {

    private final List<Book> books = new ArrayList<>();

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAllByNamed(String criteria) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getNamedBook().toLowerCase().contains(criteria.toLowerCase(Locale.ROOT))) {
                result.add(book);
            }
        }

        return result;
    }
}
