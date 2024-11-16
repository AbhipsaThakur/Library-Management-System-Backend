package com.example.springsecurity.test.librarymanagementsystembackend.service;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorSaveDTO;

public interface AuthorService {
    String addAuthor(AuthorSaveDTO authorSaveDTO);
}
