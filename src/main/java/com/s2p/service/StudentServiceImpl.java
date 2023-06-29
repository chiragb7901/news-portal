package com.s2p.service;

import com.s2p.dao.IStudentDAO;
import com.s2p.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    IStudentDAO studentDAO;
    @Override
    public List<Student> callAllFunctions() {
        Student s = new Student();
        s.setEmail("a@b.com");
        s.setName("Gandhar");
        studentDAO.save(s);
        List<Student> ls = studentDAO.findByNameContaining("har");
        System.out.println(ls);
        return ls;
    }
}
