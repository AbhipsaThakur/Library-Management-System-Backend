package com.example.springsecurity.test.librarymanagementsystembackend.repo;

import com.example.springsecurity.test.librarymanagementsystembackend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
