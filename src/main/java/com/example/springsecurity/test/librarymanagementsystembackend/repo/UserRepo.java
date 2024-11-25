package com.example.springsecurity.test.librarymanagementsystembackend.repo;

import com.example.springsecurity.test.librarymanagementsystembackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
