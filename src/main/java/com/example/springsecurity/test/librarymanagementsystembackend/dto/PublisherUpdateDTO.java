package com.example.springsecurity.test.librarymanagementsystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublisherUpdateDTO {
    private int publisherId;
    private String publisherName;
}
