package com.example.springsecurity.test.librarymanagementsystembackend.service;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherUpdateDTO;

import java.util.List;

public interface PublisherService {

    String addPublisher(PublisherSaveDTO publisherSaveDTO);

    List<PublisherDTO> getAllPublisher();

    PublisherDTO getPublisherById(int id);

    String updatePublisher(PublisherUpdateDTO publisherUpdateDTO);
}
