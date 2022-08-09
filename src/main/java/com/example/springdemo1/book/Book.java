package com.example.springdemo1.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
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

    public Book(String bookName, String author, Long bookCount) {
        this.bookName = bookName;
        this.author = author;
        this.bookCount = bookCount;
    }

    private String bookName;
    private String author;
    private Long bookCount;


}
