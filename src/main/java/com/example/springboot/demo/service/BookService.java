package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.Book;
import com.example.springboot.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getallBooks(String title){
        return bookRepository.getAllBooksByTitle(title);
    }


}



