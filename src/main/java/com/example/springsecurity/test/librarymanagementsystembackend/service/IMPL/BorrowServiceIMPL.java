package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.BorrowDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BorrowSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Borrow;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.BookRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.BorrowRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.UserRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.AuthorRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.PublisherRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BorrowRepo borrowRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public String addBorrow(BorrowSaveDTO borrowSaveDTO) {
        Borrow borrow = new Borrow(
                bookRepo.findById(borrowSaveDTO.getBookid()).orElse(null),
                userRepo.findById(borrowSaveDTO.getUserid()).orElse(null),
                borrowSaveDTO.getBorrowDate(),
                borrowSaveDTO.getReturnDate()
        );

        borrowRepo.save(borrow); // Save the Borrow entity
        return "Borrow record saved successfully"; // Return success message
    }

    @Override
    public List<BorrowDTO> getAllBorrowel() {
        List<Borrow> getBorrowel = borrowRepo.findAll();
        List<BorrowDTO> borrowDTOList = new ArrayList<>();
        for (Borrow borrow : getBorrowel) {
            BorrowDTO borrowDTO = new BorrowDTO(
                    borrow.getId(),
                    borrow.getBook(),
                    borrow.getUser(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()
            );
            borrowDTOList.add(borrowDTO);
        }
        return borrowDTOList;
    }
}
