package com.example.springsecurity.test.librarymanagementsystembackend.Controller;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookUpdateDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(path = "/save")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        String booktitle = bookService.addBook(bookSaveDTO);
        return booktitle;
    }
    @GetMapping(path = "/getAllBook")
    public List<BookDTO> getAllBook() {
        List<BookDTO> allBooks = bookService.getAllBook();
        return allBooks;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") int id) {
        BookDTO book = bookService.getBookByid(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public String updateBooks(@RequestBody BookUpdateDTO bookUpdateDTO) {
        String booktitle = bookService.updateBooks(bookUpdateDTO);
        return "Updated Successfully";
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteBooks(@PathVariable (value = "id") int id) {
        String bookname = bookService.deleteBooks(id);
        return "Deleted Successfully";
    }

}
