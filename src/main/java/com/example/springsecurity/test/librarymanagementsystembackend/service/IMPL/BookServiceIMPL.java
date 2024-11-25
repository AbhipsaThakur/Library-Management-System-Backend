package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.ResourceNotFountException;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BookUpdateDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Book;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.AuthorRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.BookRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.PublisherRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(
                bookSaveDTO.getBooktitle(),
                authorRepo.findById(bookSaveDTO.getAuthorid()).orElse(null),
                publisherRepo.findById(bookSaveDTO.getPublisherid()).orElse(null)
        );
        bookRepo.save(book);
        return bookSaveDTO.getBooktitle();
    }

    @Override
    public List<BookDTO> getAllBook() {
        List<Book> getbooks = bookRepo.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : getbooks) {
            // Retrieve author and publisher names
            String authorName = book.getAuthor() != null ? book.getAuthor().getAuthorname() : null;
            String publisherName = book.getPublisher() != null ? book.getPublisher().getPublishername() : null;

            BookDTO bookDTO = new BookDTO(
                    book.getBookid(),
                    book.getBooktitle(),
                    authorName,
                    publisherName
            );
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public BookDTO getBookByid(int id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("Book", "id", id));
        String authorName = book.getAuthor() != null ? book.getAuthor().getAuthorname() : null;
        String publisherName = book.getPublisher() != null ? book.getPublisher().getPublishername() : null;
        return new BookDTO(book.getBookid(), book.getBooktitle(), authorName, publisherName);
    }

    @Override
    public String updateBooks(BookUpdateDTO bookUpdateDTO) {
        if(bookRepo.existsById(bookUpdateDTO.getBookid())) {
            Book book = bookRepo.getById(bookUpdateDTO.getBookid());
            book.setAuthor(authorRepo.getById(bookUpdateDTO.getAuthorid()));
            book.setPublisher(publisherRepo.getById(bookUpdateDTO.getPublisherid()));
            bookRepo.save(book);
            return book.getBooktitle();
        }
        else{
            System.out.println("Book Id not found");
        }
        return null;
    }

    @Override
    public String deleteBooks(int id) {
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        }
        else{
            System.out.println("Book Id not found");
        }
        return null;
    }
}
