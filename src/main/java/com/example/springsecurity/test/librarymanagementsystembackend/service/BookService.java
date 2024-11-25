package com.example.springsecurity.test.librarymanagementsystembackend.service;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);
    List<BookDTO> getAllBook();

    BookDTO getBookByid(int id);

    String updateBooks(BookUpdateDTO bookUpdateDTO);

    String deleteBooks(int id);
}
