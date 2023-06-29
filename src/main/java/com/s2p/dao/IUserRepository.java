package com.s2p.dao;

import com.s2p.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
//    public long findIdByName(String name);
//    public User update(User d);
}
