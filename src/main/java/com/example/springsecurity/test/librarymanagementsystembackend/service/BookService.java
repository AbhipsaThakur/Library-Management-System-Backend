package com.example.springsecurity.test.librarymanagementsystembackend.service;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookSaveDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);


}
