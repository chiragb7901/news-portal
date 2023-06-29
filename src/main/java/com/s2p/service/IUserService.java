package com.s2p.service;

import com.s2p.dto.UserDTO;
import com.s2p.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public List<UserDTO> getAll();
    public UserDTO add(UserDTO u);
    public UserDTO update(long id, UserDTO u);

    public boolean delete(long id);
}
