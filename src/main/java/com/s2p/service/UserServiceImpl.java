package com.s2p.service;

import com.s2p.dao.IUserRepository;
import com.s2p.dto.UserDTO;
import com.s2p.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;

    public UserDTO ConvertUserToDTO(User u) {
        UserDTO u1 = new UserDTO();
        u1.setId(u.getId());
        u1.setEmail(u.getEmail());
        u1.setUserpassword(u.getUserpassword());
        return u1;
    }

    public User ConvertUserDTOtoUser(UserDTO u) {
        User u1 = new User();
        u1.setId(u.getId());
        u1.setEmail(u.getEmail());
        u1.setUserpassword(u.getUserpassword());
        System.out.println(u1);
        return u1;
    }

    public List<UserDTO> convertListToDto(List<User> u) {
        List<UserDTO> u1 = new ArrayList<>();
        Iterator<User> it = u.iterator();
        while (it.hasNext()) {
            UserDTO us = ConvertUserToDTO(it.next());
            u1.add(us);
        }
        return u1;
    }

    public List<User> convertDTOToList(List<UserDTO> u) {
        List<User> u1 = new ArrayList<>();
        Iterator<UserDTO> it = u.iterator();
        while (it.hasNext()) {
            User us = ConvertUserDTOtoUser(it.next());
            u1.add(us);
        }
        return u1;
    }

    @Override
    public UserDTO add(UserDTO u) {
        User u1 = ConvertUserDTOtoUser(u);
        User u2 = userRepository.save(u1);
        return ConvertUserToDTO(u2);
    }

    @Override
    public List<UserDTO> getAll() {

        return convertListToDto(userRepository.findAll());
    }

    @Override
    public UserDTO update(long id,UserDTO u){

        User u1 = userRepository.findById(id).get();

        if(u1 != null){
            if(u.getEmail() != null){
                u1.setEmail(u.getEmail());}
            if(u.getUserpassword() != null){
                u1.setUserpassword(u.getUserpassword());}
        }

        return ConvertUserToDTO(userRepository.save(u1));
    }

    @Override
    public boolean delete(long id) {
        UserDTO u = ConvertUserToDTO(userRepository.findById(id).get());
        if(u != null){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
