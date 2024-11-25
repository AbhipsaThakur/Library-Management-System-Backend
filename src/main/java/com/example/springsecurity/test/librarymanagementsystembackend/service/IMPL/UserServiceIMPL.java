package com.example.springsecurity.test.librarymanagementsystembackend.service.IMPL;

import com.example.springsecurity.test.librarymanagementsystembackend.dto.AuthorDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.UserDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.UserSaveDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.dto.UserUpdateDTO;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.Author;
import com.example.springsecurity.test.librarymanagementsystembackend.entity.User;
import com.example.springsecurity.test.librarymanagementsystembackend.repo.UserRepo;
import com.example.springsecurity.test.librarymanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public String adduser(UserSaveDTO userSaveDTO) {
        User user = new User(
                userSaveDTO.getUsername(),
                userSaveDTO.getUseremail()
        );
        userRepo.save(user);
        return user.getUsername();
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> getUsers = userRepo.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : getUsers) {
            UserDTO userDTO = new UserDTO(
                    user.getUserid(),
                    user.getUsername(),
                    user.getUseremail()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public UserDTO getUserByid(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return new UserDTO(user.getUserid(),user.getUseremail(),user.getUsername());
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if (userRepo.existsById(userUpdateDTO.getUserid())) {
            User user = userRepo.getById(userUpdateDTO.getUserid());
            user.setUsername(userUpdateDTO.getUsername());
            userRepo.save(user);
            return user.getUsername();
        }
        else {
            System.out.println("User id not found!!");
        }
        return null;
    }

    @Override
    public String deleteUser(int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        }
        else{
            System.out.println("User id not found!!");
        }
        return "";
    }
}
