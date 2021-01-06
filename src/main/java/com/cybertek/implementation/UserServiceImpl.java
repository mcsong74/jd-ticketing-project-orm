package com.cybertek.implementation;

import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.mapper.UserMapper;
import com.cybertek.repository.UserRepository;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserDTO> listAllUsers() {
        List<User> list=userRepository.findAll(Sort.by("firstName"));
        //convert entity to DTO
        return list.stream()
                .map(obj-> {return userMapper.convertToDTO(obj);})
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String userName) {
        User user=userRepository.findByUserName(userName);
        return userMapper.convertToDTO(user);
    }

    @Override
    public void save(UserDTO dto) {
        User user=userMapper.convertToEntity(dto);
        userRepository.save(user);

    }

    @Override
    public UserDTO update(UserDTO dto) {
        //Find current user
        User user = userRepository.findByUserName(dto.getUserName());
        //Map update user dto to entity object
        User convertedUser= userMapper.convertToEntity(dto);
        //set id to the converted object
        convertedUser.setId(user.getId());
        //save updated user
        userRepository.save(convertedUser);
        return findByUserName(dto.getUserName());
    }

    @Override
    public void delete(String username) {
        User user=userRepository.findByUserName(username);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public void deleteByUserName(String username) {
        //hard delete
        userRepository.deleteByUserName(username);
    }
}
