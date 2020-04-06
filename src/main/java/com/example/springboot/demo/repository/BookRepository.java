package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {


    @Query("SELECT b FROM Book b WHERE b.bookTitle like  %:title%")
    public List<Book> getAllBooksByTitle(@Param("title") String title);

}
