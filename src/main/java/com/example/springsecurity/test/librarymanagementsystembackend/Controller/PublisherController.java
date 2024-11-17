package com.example.springsecurity.test.librarymanagementsystembackend.Controller;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.PublisherSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @PostMapping(path = "/save")
    public String savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO) {
        String publishername = publisherService.addPublisher(publisherSaveDTO);
        return publishername;
    }
    @GetMapping(path = "/getAllPublisher")
    public List<PublisherDTO > getAllPublisher(){
        List<PublisherDTO> allPublishers = publisherService.getAllPublisher();
        return allPublishers;
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable("id") int id) {
        PublisherDTO publisher = publisherService.getPublisherById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

}
