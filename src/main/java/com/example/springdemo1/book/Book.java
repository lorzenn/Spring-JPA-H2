package com.example.springdemo1.book;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long bookId;
    private String bookName;

    public Book() {
    }

    public Book(Long bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }
}
