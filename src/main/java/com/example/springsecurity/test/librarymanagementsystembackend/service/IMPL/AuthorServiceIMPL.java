package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Author;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.AuthorRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {
        Author author = new Author(authorSaveDTO.getAuthorname());
        authorRepo.save(author);
        return author.getAuthorname();
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> getauthors = authorRepo.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();
        for (Author author : getauthors) {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorid(),
                    author.getAuthorname()
            );
            authorDTOList.add(authorDTO);
        }
        System.out.println("Authors retrieved: " + authorDTOList.size());
        return authorDTOList;
    }
}
