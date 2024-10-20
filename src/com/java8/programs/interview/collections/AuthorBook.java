package com.java8.programs.interview.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
    private String name;
    private List<String> authors;
    private int year;
    private double price;

    public Book(String name, List<String> authors, int year, double price) {
        this.name = name;
        this.authors = authors;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + authors +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}

public class AuthorBook{
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book1", Arrays.asList("Author1", "Author2"), 1990, 29.99),
                new Book("Book2", Arrays.asList("Author1", "Author3"), 1995, 39.99),
                new Book("Book3", Arrays.asList("Author2", "Author3"), 2000, 19.99),
                new Book("Book4", Arrays.asList("Author1"), 2010, 49.99)
        );

        // Find the author who has written the most number of books
        String mostProlificAuthor = books.stream().flatMap(e-> e.getAuthors().stream())
                .collect(Collectors.groupingBy(a->a, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry :: getKey)
                .orElse("");

        System.out.println(mostProlificAuthor);

    }
}