package com.s2p.controller;

import com.s2p.dto.ContactDTO;
import com.s2p.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/contacts")
public class ContactController {
@Autowired
    IContactService contactService;

    @GetMapping("contacts/{studentId}")
    public List<ContactDTO> getContactsById(@PathVariable("studentId") long studentId){
        return contactService.getAllContactsByStudentID(studentId);
    }
    @PostMapping("contacts/add")
     ContactDTO add(@RequestBody ContactDTO c){
        System.out.println(c);
        return contactService.addContact(c);
    }
}
