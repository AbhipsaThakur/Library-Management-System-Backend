package com.example.springsecurity.test.librarymanagementsystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdateDTO {
    private int bookid;
    private String booktitle;
    private int authorid;
    private int publisherid;
}
