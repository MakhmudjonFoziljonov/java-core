package lesson03.book;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;


public class BookService implements BookRepository {
    final Map<String, Book> storage = new HashMap<>();

        @Override
        public List<Book> getBooks() {
            return new ArrayList<>(storage.values());
        }

        @Override
        public void addNewBook(Book book) {
            Objects.requireNonNull(book, "book required");
            Book prev = storage.putIfAbsent(book.getIsbn(), book);
            if (prev != null) {
                throw new IllegalArgumentException("Book with ISBN already exists: " + book.getIsbn());
            }
        }

        @Override
        public void reserveBook(String isbn) {
            Book book = storage.get(isbn);
            if (book == null) throw new NoSuchElementException("Book not found: " + isbn);
            book.reserve();
        }

}
