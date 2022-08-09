package com.example.springdemo1.book;

import com.example.springdemo1.book.dto.APIResponse;
import com.example.springdemo1.department.Department;
import com.example.springdemo1.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("get_books")
    public APIResponse<List<Book>> getBooks() {
        List<Book> allBooks = bookService.getBooks();
        return new APIResponse<>(allBooks.size(), allBooks);
    }

    @GetMapping("/get_books/sort/{field}")
    public APIResponse<List<Book>> getBooksWithSort(@PathVariable String field) {
        List<Book> allBooks = bookService.findBooksWithSorting(field);
        return new APIResponse<>(allBooks.size(), allBooks);
    }

    @GetMapping("/get_books/page_{offset}/{pageSize}")
    public APIResponse<Page<Book>> getBooksWithPage(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Book> booksWithPagination = bookService.findBooksWithPagination(offset, pageSize);
        return new APIResponse<>(booksWithPagination.getSize(), booksWithPagination);
    }

    @GetMapping("/get_books/page_{offset}/{pageSize}/{field}")
    public APIResponse<Page<Book>> getBooksWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Book> booksWithPaginationAndSorting = bookService.findBooksWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(booksWithPaginationAndSorting.getSize(), booksWithPaginationAndSorting);
    }

    @GetMapping("{bookId}")
    public Book getBook(@PathVariable("bookId") Long bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping("/add")
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteDepartment(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
    }
}
