package com.example.springsecurity.test.librarymanagementsystembackend.dto;

import com.example.springsecurity.test.librarymanagementsystembackend.entity.Book;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowUpdateDTO {
    private Book book;
    private User user;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
