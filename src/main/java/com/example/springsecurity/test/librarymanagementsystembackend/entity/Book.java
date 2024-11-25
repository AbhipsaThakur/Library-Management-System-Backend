package com.example.springsecurity.test.librarymanagementsystembackend.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid", length = 11)
    private int bookid;

    @Column(name = "booktitle", length = 50)
    private String booktitle;

    @ManyToOne
    @JoinColumn(name = "authorid")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisherid")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows;


    // Constructor matching the parameters in BookServiceIMPL
    public Book(String booktitle, Author author, Publisher publisher) {
        this.booktitle = booktitle;
        this.author = author;
        this.publisher = publisher;
    }

    // Existing constructors
    public Book(int bookid, String booktitle) {
        this.bookid = bookid;
        this.booktitle = booktitle;
    }

    public Book(String booktitle) {
        this.booktitle = booktitle;
    }

    public Book() {
    }

    // Getters and setters
    public int getBookid() {

        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", booktitle='" + booktitle + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
