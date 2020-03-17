package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.Book;
import com.example.springboot.demo.model.BookAuthorAndTitle;
import com.example.springboot.demo.repository.BookCustomRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    BookCustomRepositoryInterface bookCustomRepositoryInterface;

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    private List<Book> getAllBooksByAuthorAndTitle() {
        return bookCustomRepositoryInterface.findAllBooksByTitleAndAuthor("Javabook", "Amit");
    }

    //Example of multiselect to select specific columns from an entity.
    @RequestMapping(method = RequestMethod.GET, value = "/booksAuthorAndTitle")
    private List<BookAuthorAndTitle> getAllBooksAuthorAndTitleByAuthorAndTitle() {
        return bookCustomRepositoryInterface.findAllBooksAuthorAndTitleByTitleAndAuthor("Javabook", "Amit");
    }
}