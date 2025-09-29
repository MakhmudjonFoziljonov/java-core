package lesson03;

import lesson03.book.Book;
import lesson03.book.BookService;
import lesson03.onlineStore.Product;
import lesson03.onlineStore.ProductService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Class Person
        Person person = new Person("Mahmudjon", 22);
        person.introduce();

        // Class Rectangle
        Rectangle rectangle = new Rectangle(8.0, 11.5);
        double perimeter = rectangle.calculatePerimeter();
        double square = rectangle.calculateSquare();
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + square);

        // Class Car
        Car car = new Car("USA", "Tahoe", 2025);
        car.printCarInfo();

        // Class Bank Account
        BankAccount acc = new BankAccount
            ("Makhmudjon Foziljonov",
                "MMM-111008822",
                new BigDecimal("19999.999"));

        acc.deposit(new BigDecimal("250.00"));
        acc.withdraw(new BigDecimal("500.00"));
        System.out.println("Balance: " + acc.getBalance());

        // Book
        BookService service = new BookService();
        Book b1 = new Book("978-77773333322", "Java Physiology", "Bryus Ekkel", 2010);
        service.addNewBook(b1);

        System.out.println(service.getBooks());
        System.out.println(b1.getBookInfo());
        service.reserveBook("978-77773333322");
        System.out.println(b1.getStatus());

        // Class Online Store / PRODUCT
        ProductService repo = new ProductService();
        Product p1 = new Product("Mac-000", "Mc", new BigDecimal("1200.00"));
        repo.addProduct(p1);

        System.out.println(repo.getProducts());
        System.out.println(repo.getProductInfo("Mac-000"));

        repo.buyProduct("Mac-000", 15);
        System.out.println(repo.getProductInfo("Mac-000"));

        // Class Bank System
        BankSystem acc1 = new BankSystem("17", "Mahmudjon Foziljonov", 1111);
        BankSystem acc2 = new BankSystem("21", "Mahmudjon1 Foziljonov!", 1199);

        BankSystem.addAccount(acc1);
        BankSystem.addAccount(acc2);

        BankSystem.getAccounts();

        acc1.replenishAccount(1000);
        BankSystem.transferMoneyBetweenAccounts("17", "21", 2000);

        BankSystem.deleteAccount("21");
        BankSystem.getAccounts();

    }
}


