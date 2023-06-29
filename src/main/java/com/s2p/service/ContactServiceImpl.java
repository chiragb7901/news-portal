package com.s2p.service;

import com.s2p.dao.IContactDAO;
import com.s2p.dao.IUserDAO;
import com.s2p.dto.ContactDTO;
import com.s2p.model.Contact;
import com.s2p.model.UserOLD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class ContactServiceImpl implements IContactService{
    @Autowired
    IContactDAO contactDAO;
    @Autowired
    IUserDAO userDAO;
    @Override
    public List<ContactDTO> getAllContactsByStudentID(long studentId) {
        UserDetails u1 = (UserDetails)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        UserOLD u = userDAO.findById(studentId).get();
        UserOLD u2 = userDAO.findByEmail(u1.getUsername());
        System.out.println(u1);
        System.out.println(u2);
        ArrayList<Contact> contacts =  (ArrayList<Contact>)contactDAO.findByUserOLDId(u.getId());
        System.out.println(contacts);
        return convertContactListToContactsDTO(contacts);
    }

    public static List<ContactDTO> convertContactListToContactsDTO(List<Contact> contacts){
        Iterator<Contact> it = contacts.iterator();
        List<ContactDTO> contactList = new ArrayList<>();
        while(it.hasNext()){
            Contact c = it.next();
            ContactDTO cdto = new ContactDTO();
            cdto.setEmail(c.getEmail());
            cdto.setDescription(c.getDescription());
            cdto.setId(c.getId());
            cdto.setName(c.getName());
            cdto.setPhone(c.getPhone());
            cdto.setCreatedOn(c.getCreatedOn());
            contactList.add(cdto);
        }
        return contactList;
    }
    @Override
    public ContactDTO addContact(ContactDTO c1) {
        UserDetails u = (UserDetails)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        UserOLD u1 = userDAO.findByEmail(u.getUsername());
        System.out.println(u1);
        Contact c = convertContactDTOToContact(c1);
        System.out.println(c);
        c.setUser(u1);
        System.out.println(c.getUser());
        Contact c2 = contactDAO.save(c);

        return convertContactToContactDTO(c2);
    }

    public Contact convertContactDTOToContact(ContactDTO c){
        Contact c1 = new Contact();
        c1.setName(c.getName());
        c1.setCreatedOn(c.getCreatedOn());
        c1.setPhone(c.getPhone());
        c1.setDescription(c.getDescription());
        c1.setId(c.getId());
        return c1;
    }

    public ContactDTO convertContactToContactDTO(Contact c){
        ContactDTO c1 = new ContactDTO();
        c1.setName(c.getName());
        c1.setCreatedOn(c.getCreatedOn());
        c1.setPhone(c.getPhone());
        c1.setDescription(c.getDescription());
        c1.setId(c.getId());
        return c1;
    }
    @Override
    public ContactDTO updateContact(Contact c) {
        return null;
    }

    @Override
    public ContactDTO deleteContact(Contact c) {
        return null;
    }
}
