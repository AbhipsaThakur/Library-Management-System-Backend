package com.example.springsecurity.test.librarymanagementsystembackend.service;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.UserDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.UserSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String adduser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();

    UserDTO getUserByid(int id);

    String updateUser(UserUpdateDTO userUpdateDTO);

    String deleteUser(int id);
}
