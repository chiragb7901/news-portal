package com.s2p.controller;

import com.s2p.model.Student;
import com.s2p.model.Tutorial;
import com.s2p.service.IStudentService;
import com.s2p.service.ITutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tutorial")
@RestController
public class TutorialController {
    @Autowired
    ITutorialService tutorialService;
    @Autowired
    IStudentService studentService;
    @GetMapping("getall")
    public List<Tutorial> getAll(){
        return tutorialService.getAll();
    }

    @PostMapping("add")
    public Tutorial add(@RequestBody Tutorial t){
        return tutorialService.add(t);
    }

    @GetMapping("test")
    public List<Student> testall(){
        return studentService.callAllFunctions();
    }
}
