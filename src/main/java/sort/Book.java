package sort;

import java.util.Objects;

public class Book {

    private String author;

    private int createdYear;

    public Book(String author, int createdYear) {
        this.author = author;
        this.createdYear = createdYear;
    }

    public String getAuthor() {
        return author;
    }

    public int getCreatedYear() {
        return createdYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return createdYear == book.createdYear && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, createdYear);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", createdYear=" + createdYear +
                '}';
    }
}
