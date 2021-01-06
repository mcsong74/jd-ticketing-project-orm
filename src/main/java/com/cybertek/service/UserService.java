package com.cybertek.service;

import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers(); //service communicate with DTO, and DTO communicate with Entity
    UserDTO findByUserName(String userName);
    void save(UserDTO dto);
    UserDTO update(UserDTO dto);
    void delete(String username);

    void deleteByUserName(String username);

    List<UserDTO> listAllByRole(String role);
    

}
