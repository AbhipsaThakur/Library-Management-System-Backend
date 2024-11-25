package com.example.springsecurity.test.librarymanagementsystembackend.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authorid", length = 11)
    private int authorid;

    @Column(name = "authorname", length = 45)
    private String authorname;

    // Reference the custom Book entity
    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public Author(int authorid, String authorname) {
        this.authorid = authorid;
        this.authorname = authorname;
    }

    public Author(String authorname) {
        this.authorname = authorname;
    }

    public Author() {

    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", authorname='" + authorname + '\'' +
                '}';
    }
}
