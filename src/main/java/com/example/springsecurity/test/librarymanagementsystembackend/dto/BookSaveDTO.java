package com.example.springsecurity.test.librarymanagementsystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookSaveDTO {
    private String booktitle;
    private int authorid;
    private int publisherId;
}
