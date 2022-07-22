package com.example.springdemo1.book;

import com.example.springdemo1.department.Department;
import com.example.springdemo1.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Book> getDepartments() {
        return bookService.getBooks();
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
