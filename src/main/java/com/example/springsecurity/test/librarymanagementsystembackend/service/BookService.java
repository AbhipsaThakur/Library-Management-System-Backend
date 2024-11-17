package com.example.springsecurity.test.librarymanagementsystembackend.service;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookSaveDTO;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);
}
