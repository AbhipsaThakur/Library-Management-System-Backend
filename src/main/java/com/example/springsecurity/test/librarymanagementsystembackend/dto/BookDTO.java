package com.example.springsecurity.test.librarymanagementsystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private int bookId;
    private String booktitle;
    private String author;
    private String publisher;
}
