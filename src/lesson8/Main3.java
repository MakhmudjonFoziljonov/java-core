package lesson8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter isbn: ");
        var key = scanner.nextLine();

        Map<String, Book> map = new HashMap<>();
        map.put(key, new Book(
            "book 1",
            "author 1",
            key
        ));

        for (Map.Entry<String, Book> m : map.entrySet()) {
            System.out.println(m.getValue());
        }
    }


    @Getter
    @Setter
    @AllArgsConstructor
    static class Book {
        private String name;
        private String author;
        private String isbn;

        @Override
        public String toString() {
            return "Book{" +
                "name='" + name + "'," +
                "author='" + author + "', " +
                "isbn='" + isbn + "'}";
        }
    }
}
