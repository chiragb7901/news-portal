package com.s2p.dao;

import com.s2p.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContactDAO extends JpaRepository <Contact,Long>{
    List<Contact> findByUserOLDId(long id);
}
