package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.Book;
import com.example.springboot.demo.model.BookAuthorAndTitle;
import com.example.springboot.demo.repository.BookCustomRepositoryInterface;
import com.example.springboot.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    BookCustomRepositoryInterface bookCustomRepositoryInterface;

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    private List<Book> getAllBooksByAuthorAndTitle() {
        return bookCustomRepositoryInterface.findAllBooksByTitleAndAuthor("Javabook", "Amit");
    }

    //Example of multiselect to select specific columns from an entity.
    @RequestMapping(method = RequestMethod.GET, value = "/booksAuthorAndTitle")
    private List<BookAuthorAndTitle> getAllBooksAuthorAndTitleByAuthorAndTitle() {
        return bookCustomRepositoryInterface.findAllBooksAuthorAndTitleByTitleAndAuthor("Javabook", "Amit");
    }

        @RequestMapping(method = RequestMethod.GET, value = "/booksByTitle/{bookTitle}")
    private List<Book> getAllBooksByTitle(@PathVariable("bookTitle") String bookTitle) {
        return bookService.getallBooks(bookTitle);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allbooks")
    private List<Book> getAllBooks() {
        return bookService.findallBooks(Sort.by("bookTitle").ascending());
    }

}
