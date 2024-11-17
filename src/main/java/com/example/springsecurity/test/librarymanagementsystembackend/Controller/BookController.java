package com.example.springsecurity.test.librarymanagementsystembackend.Controller;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(path = "/save")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        String booktitle = bookService.addBook(bookSaveDTO);
        return booktitle;
    }
}
