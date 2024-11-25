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
        Publisher publisher = new Publisher(publisherSaveDTO.getPublishername());
        publisherRepo.save(publisher);
        return publisher.getPublishername();
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> getpublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();
        for (Publisher publisher : getpublishers) {
            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherid(),
                    publisher.getPublishername()
            );
            publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;
    }

    @Override
    public PublisherDTO getPublisherById(int id) {
        Publisher publisher = publisherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("Publisher", "id", id));
        return new PublisherDTO(publisher.getPublisherid(), publisher.getPublishername());
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {
        if (publisherRepo.existsById(publisherUpdateDTO.getPublisherid())) {
            Publisher publisher = publisherRepo.findById(publisherUpdateDTO.getPublisherid())
                    .orElseThrow(() -> new ResourceNotFountException("Publisher", "id", publisherUpdateDTO.getPublisherid()));
            publisher.setPublishername(publisherUpdateDTO.getPublishername());
            publisherRepo.save(publisher);
            return publisher.getPublishername();
        } else {
            throw new ResourceNotFountException("Publisher", "id", publisherUpdateDTO.getPublisherid());
        }
    }

    @Override
    public String deletePublisher(int id) {
        if (publisherRepo.existsById(id)) {
            publisherRepo.deleteById(id);
        }else{
            System.out.println("Publisher ID not found");
        }
        return "Publisher deleted";
    }
}
