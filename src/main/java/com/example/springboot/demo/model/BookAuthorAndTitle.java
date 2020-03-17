package com.example.springboot.demo.model;

public class BookAuthorAndTitle {
    String bookAuthor;
    String bookTitle;

    public BookAuthorAndTitle() {
    }

    public BookAuthorAndTitle(String bookAuthor, String bookTitle) {
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
