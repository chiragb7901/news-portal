package com.s2p.dao;

import com.s2p.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
public interface IStudentDAO extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
    List<Student> findByNameStartingWith(String name);

    List<Student> findByNameContaining(String name);
    List<Student> findByNameEndingWith(String name);
    List<Student> findByNameLike(String pattern);

    List<Student> findByMarksLessThan(double marks);

    List<Student> findByMarksBetween(double startMarks, double endMarks);

    List<Student> findByMarksIn(Collection<Double> marks);

    List<Student> findByNameOrderByNameDesc(String fname);
}
