package com.example.backend.book;


import java.util.Random;

public class Book {

    Random random = new Random();
    public Long id;
    public String name;
    public String author;

    public Integer quantity;
    public Integer releasedYear;

    public Book() {
    }

    public Book(String name, String author, Integer quantity, Integer releasedYear) {
        this.id = random.nextLong(1243423523, Integer.MAX_VALUE);
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.releasedYear = releasedYear;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                ", releasedYear=" + releasedYear +
                '}';
    }
}
