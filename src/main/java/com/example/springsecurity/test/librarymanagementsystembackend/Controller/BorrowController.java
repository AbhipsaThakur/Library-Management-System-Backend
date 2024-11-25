package com.example.springsecurity.test.librarymanagementsystembackend.Controller;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BorrowDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.BorrowSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Borrow;
import com.example.springsecurity.test.librarymanagementsystembackend.service.AuthorService;
import com.example.springsecurity.test.librarymanagementsystembackend.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping(path = "/save")
    public String saveBorrow(@RequestBody BorrowSaveDTO borrowSaveDTO) {
        String BorrowBooks = borrowService.addBorrow(borrowSaveDTO);
        return "Borrowel Successfully";
    }
    @GetMapping(path = "/getAllBorrowel")
    public List<BorrowDTO> getAllBorrowel() {
        List<BorrowDTO> allborrow = borrowService.getAllBorrowel();
        return allborrow;
    }
}
