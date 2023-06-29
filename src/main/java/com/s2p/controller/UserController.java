package com.s2p.controller;

import com.s2p.dao.IUserRepository;
import com.s2p.dto.UserDTO;
import com.s2p.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/getAll")
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public UserDTO add(@RequestBody UserDTO u){
        System.out.println("-------" + u);
        return userService.add(u);
    }

    @DeleteMapping("/delete/{id}")
    public String  delete(@PathVariable("id") long id ){
        if(userService.delete(id)){
            return "User Deleted Successfully";
        }
        return "User not deleted";
    }

    @PutMapping("/update/{id}")
    public UserDTO update(@PathVariable("id") long id,
                          @RequestBody UserDTO u){
        return userService.update(id,u);
    }
}
