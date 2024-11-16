package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorUpdateDTO;
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
        return authorDTOList;
    }

    @Override
    public AuthorDTO getAuthorById(int id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + id));
        return new AuthorDTO(author.getAuthorid(), author.getAuthorname());
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {
        if (authorRepo.existsById(authorUpdateDTO.getAuthorid())) {
            Author author = authorRepo.getById(authorUpdateDTO.getAuthorid());
            author.setAuthorname(authorUpdateDTO.getAuthorname());
            authorRepo.save(author);
            return author.getAuthorname();
        }
        else {
            System.out.println("Author id not found!!");
        }
        return null;
    }

    @Override
    public String deleteAuthor(int id) {
        if (authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
        }
        else{
            System.out.println("Author id not found!!");
        }
        return "";
    }


}
