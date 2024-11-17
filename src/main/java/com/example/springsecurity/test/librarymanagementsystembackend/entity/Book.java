package com.example.springsecurity.test.librarymanagementsystembackend.entity;

import jakarta.persistence.*;

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

    public Book(int bookid, String booktitle) {
        this.bookid = bookid;
        this.booktitle = booktitle;
    }

    public Book(String booktitle) {
        this.booktitle = booktitle;
    }

    public Book(){

    }

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

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", booktitle='" + booktitle + '\'' +
                '}';
    }
}
