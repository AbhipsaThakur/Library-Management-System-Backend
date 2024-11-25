package com.example.springsecurity.test.librarymanagementsystembackend.repo;

import com.example.springsecurity.test.librarymanagementsystembackend.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<Borrow, Integer> {
}
