package com.example.springsecurity.test.librarymanagementsystembackend.repo;

import com.example.springsecurity.test.librarymanagementsystembackend.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository <Publisher, Integer> {
}
