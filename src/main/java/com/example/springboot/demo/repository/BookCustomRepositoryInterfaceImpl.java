package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.Book;
import com.example.springboot.demo.entities.Book_;
import com.example.springboot.demo.model.BookAuthorAndTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookCustomRepositoryInterfaceImpl implements BookCustomRepositoryInterface {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Book> findAllBooksByTitleAndAuthor(String bookTitle, String bookAuthor) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQueryBook = cb.createQuery(Book.class);

        Root<Book> bookRoot = criteriaQueryBook.from(Book.class);

        //Predicate titlePredicate = cb.equal(bookRoot.get("bookTitle"), bookTitle);
        Predicate titlePredicate = cb.equal(bookRoot.get(Book_.bookTitle), bookTitle);
        Predicate authorPredicate = cb.equal(bookRoot.get(Book_.bookAuthor), bookAuthor);
        //  Predicate authorPredicate = cb.equal(bookRoot.get("bookAuthor"), bookAuthor);

        criteriaQueryBook.where(titlePredicate, authorPredicate);

        TypedQuery<Book> query = entityManager.createQuery(criteriaQueryBook);

        List<Book> resultList = query.getResultList();
        return resultList;

    }

    @Override
    public List<BookAuthorAndTitle> findAllBooksAuthorAndTitleByTitleAndAuthor(String bookTitle, String bookAuthor) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookAuthorAndTitle> criteriaQueryBook = cb.createQuery(BookAuthorAndTitle.class);

        Root<Book> bookRoot = criteriaQueryBook.from(Book.class);

        Predicate titlePredicate = cb.equal(bookRoot.get(Book_.bookTitle), bookTitle);
        Predicate authorPredicate = cb.equal(bookRoot.get(Book_.bookAuthor), bookAuthor);


        criteriaQueryBook.where(titlePredicate, authorPredicate);
        criteriaQueryBook.multiselect(bookRoot.get(Book_.bookAuthor),bookRoot.get(Book_.bookTitle));


        TypedQuery<BookAuthorAndTitle> query = entityManager.createQuery(criteriaQueryBook);

        List<BookAuthorAndTitle> resultList = query.getResultList();
        return resultList;
    }

}
