package com.example.springsecurity.test.librarymanagementsystembackend.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisherid", length = 11)
    private int publisherid;

    @Column(name = "publishername", length = 45)
    private String publishername;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher(int publisherid, String publishername) {
        this.publisherid = publisherid;
        this.publishername = publishername;
    }

    public Publisher(String publishername) {
        this.publishername = publishername;
    }

    public Publisher() {
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherid=" + publisherid +
                ", publishername='" + publishername + '\'' +
                '}';
    }
}
