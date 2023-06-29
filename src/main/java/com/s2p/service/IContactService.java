package com.s2p.service;

import com.s2p.dto.ContactDTO;
import com.s2p.model.Contact;

import java.util.List;

public interface IContactService {
    public List<ContactDTO> getAllContactsByStudentID(long studentId);
    public ContactDTO addContact(ContactDTO c);
    public ContactDTO updateContact(Contact c);

    public ContactDTO deleteContact(Contact c);
}
