package com.s2p.dao;
import com.s2p.model.UserOLD;
import org.springframework.data.repository.CrudRepository;
public interface IUserDAO extends CrudRepository<UserOLD, Long> {
//    User findByUsername(String username);
    UserOLD findByEmail(String email);
}