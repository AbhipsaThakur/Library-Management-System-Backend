package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.ResourceNotFountException;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherUpdateDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Publisher;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.PublisherRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceIMPL implements PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(publisherSaveDTO.getPublisherName());
        publisherRepo.save(publisher);
        return publisher.getPublisherName();
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> getpublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();
        for (Publisher publisher : getpublishers) {
            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherId(),
                    publisher.getPublisherName()
            );
            publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;
    }

    @Override
    public PublisherDTO getPublisherById(int id) {
        Publisher publisher = publisherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("Publisher", "id", id));
        return new PublisherDTO(publisher.getPublisherId(), publisher.getPublisherName());
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {
        if (publisherRepo.existsById(publisherUpdateDTO.getPublisherId())) {
            Publisher publisher = publisherRepo.findById(publisherUpdateDTO.getPublisherId())
                    .orElseThrow(() -> new ResourceNotFountException("Publisher", "id", publisherUpdateDTO.getPublisherId()));
            publisher.setPublisherName(publisherUpdateDTO.getPublisherName());
            publisherRepo.save(publisher);
            return publisher.getPublisherName();
        } else {
            throw new ResourceNotFountException("Publisher", "id", publisherUpdateDTO.getPublisherId());
        }
    }
}
