package sort;

public class BookService {

    /**
     * Используя алгоритм сортировки выбором отсортируйте книги по их году.
     * Алгоритм можно найти тут - https://favtutor.com/blogs/sorting-algorithms-java
     * В данной задаче ЗАПРЕЩЕНО использовать Comparator.
     * @param books неупорядоченные книги
     * @return отсортированные книги по году.
     */
    public Book[] sortBookByYear(Book[] books) {

        if (books.length == 1)
        {
            return books;
        }

        for (int i = 0; i < books.length - 1; i++)
        {
            for (int j = 0; j < books.length - 1; j ++) {
                if (books[j].getCreatedYear() > books[j + 1].getCreatedYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
        return books;
    }
}
