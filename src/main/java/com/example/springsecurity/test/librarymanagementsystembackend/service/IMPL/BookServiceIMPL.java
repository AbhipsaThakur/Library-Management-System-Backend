package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Book;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.AuthorRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.BookRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.PublisherRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(
                bookSaveDTO.getBooktitle(),
                authorRepo.findById(bookSaveDTO.getAuthorid()).orElse(null),
                publisherRepo.findById(bookSaveDTO.getPublisherId()).orElse(null)
        );
        bookRepo.save(book);
        return bookSaveDTO.getBooktitle();
    }

}
