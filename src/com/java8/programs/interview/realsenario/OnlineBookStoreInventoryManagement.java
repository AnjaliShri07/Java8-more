package com.java8.programs.interview.realsenario;
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

class Bookstore {
    private List<Book> inventory;

    public Bookstore() {
        this.inventory = new ArrayList<>();
    }

    public void addBook(Book book) {
        inventory.add(book);
    }

    public void removeBook(String title) {
        inventory.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void displayBooks() {
        for (Book book : inventory) {
            System.out.println(book);
        }
    }
}
public class OnlineBookStoreInventoryManagement {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        bookstore.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99));
        bookstore.addBook(new Book("1984", "George Orwell", 8.99));
        bookstore.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 12.99));

        System.out.println("Books in inventory:");
        bookstore.displayBooks();

        bookstore.removeBook("1984");

        System.out.println("\nBooks in inventory after removal:");
        bookstore.displayBooks();
    }
}
