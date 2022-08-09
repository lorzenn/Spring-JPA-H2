package com.example.springdemo1.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @PostConstruct
    public void initDB() {
        List<Book> books = IntStream.rangeClosed(1, 200)
                .mapToObj(i -> new Book("book_" + i, "Lorenz_" +i, (long) new Random().nextInt(500000)))
                .collect(Collectors.toList());
        bookRepository.saveAll(books);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void createBook(Book book) {
        new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> findBooksWithSorting(String field) {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public Page<Book> findBooksWithPagination(int offset, int pageSize){
        Page<Book> books = bookRepository.findAll(PageRequest.of(offset, pageSize));
        return books;
    }

    @Override
    public Page<Book> findBooksWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Book> books = bookRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return books;
    }


}
