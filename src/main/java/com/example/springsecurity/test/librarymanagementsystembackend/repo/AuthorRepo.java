package com.example.springsecurity.test.librarymanagementsystembackend.repo;

import com.example.springsecurity.test.librarymanagementsystembackend.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
