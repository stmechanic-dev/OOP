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
            if (books[i].getCreatedYear() > books[i+1].getCreatedYear())
            {
                Book temp = books[i];
                books[i] = books[i + 1];
                books[i + 1] = temp;
            }
        }
        return books;
    }
}
