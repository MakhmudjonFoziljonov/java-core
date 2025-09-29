package lesson03.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    private final String isbn;
    private final String name;
    private final String author;
    private final int year;
    private BookStatus status;

    public void reserve() {
        synchronized (this) {
            if (status != BookStatus.AVAILABLE) {
                throw new IllegalStateException("Book is not available to reserve");
            }
            status = BookStatus.RESERVED;
        }
    }

    public String getBookInfo() {
        return String.format("Book" +
                "{" +
                "isbn='%s', name='%s', author='%s', year=%d, status=%s" +
                "}",
            isbn, name, author, year, status);
    }
}
