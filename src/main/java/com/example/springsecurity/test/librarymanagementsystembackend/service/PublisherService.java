package com.example.springsecurity.test.librarymanagementsystembackend.service;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherSaveDTO;

public interface PublisherService {
    
    String addPublisher(PublisherSaveDTO publisherSaveDTO);
}
