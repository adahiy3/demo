package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.Book;
import com.example.springboot.demo.model.BookAuthorAndTitle;

import java.util.List;

public interface BookCustomRepositoryInterface {

    public List<Book> findAllBooksByTitleAndAuthor(String bookTitle, String bookAuthor);

    public List<BookAuthorAndTitle> findAllBooksAuthorAndTitleByTitleAndAuthor(String bookTitle, String bookAuthor);


}
