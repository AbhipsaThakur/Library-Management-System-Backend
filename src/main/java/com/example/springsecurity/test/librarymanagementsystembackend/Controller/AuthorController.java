package com.example.springsecurity.test.librarymanagementsystembackend.Controller;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO) {
        String authorname = authorService.addAuthor(authorSaveDTO);
        return "Added Successfully";
    }

    @GetMapping(path = "/getAllAuthor")
    public List<AuthorDTO> getAllAuthor() {
        List<AuthorDTO> allAuthors = authorService.getAllAuthor();
        return allAuthors;
    }
}
