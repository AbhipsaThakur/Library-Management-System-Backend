package com.example.springsecurity.test.librarymanagementsystembackend.Controller;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.*;
import com.example.springsecurity.test.librarymanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO) {
        String username = userService.adduser(userSaveDTO);
        return "User Information Added Succfully";
    }

    @GetMapping(path = "/getAllUser")
    public List<UserDTO> getAllUser() {
        List<UserDTO> allUser = userService.getAllUser();
        return allUser;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id) {
        UserDTO user = userService.getUserByid(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        String username = userService.updateUser(userUpdateDTO);
        return "Updated Successfully";
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteUser(@PathVariable (value = "id") int id) {
        String username = userService.deleteUser(id);
        return "User Deleted Successfully";
    }
}
