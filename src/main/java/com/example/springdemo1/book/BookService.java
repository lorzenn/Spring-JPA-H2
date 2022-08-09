package com.example.springdemo1.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    void initDB();

    List<Book> getBooks();
    Book getBook(Long bookId);
    void createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long bookId);

    List<Book> findBooksWithSorting(String field);
    Page<Book> findBooksWithPagination(int offset, int pageSize);
    Page<Book> findBooksWithPaginationAndSorting(int offset, int pageSize, String field);

}
