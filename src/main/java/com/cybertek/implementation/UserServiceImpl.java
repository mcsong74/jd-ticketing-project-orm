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
        return null;
    }

    @Override
    public void save(UserDTO dto) {
        User user=userMapper.convertToEntity(dto);
        userRepository.save(user);

    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void delete(String username) {

    }
}
