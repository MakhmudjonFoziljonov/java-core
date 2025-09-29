package lesson03.book;

import java.util.List;


public interface BookRepository {

     List<Book> getBooks();
     void addNewBook(Book book);
     void reserveBook(String isbn);
}
