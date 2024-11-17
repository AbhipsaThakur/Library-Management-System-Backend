package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Publisher;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.PublisherRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceIMPL implements  PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(publisherSaveDTO.getPublisherName());
        publisherRepo.save(publisher);
        return publisher.getPublisherName();
    }
}
