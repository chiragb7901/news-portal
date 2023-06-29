package com.s2p.controller;

import com.s2p.dto.SectionDTO;
import com.s2p.model.Section;
import com.s2p.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    ISectionService sectionService;

    @GetMapping("/getAll")
    public List<SectionDTO> getAll(){
        return sectionService.getAll();
    }

    @PostMapping("/add")
    public SectionDTO add(@RequestBody SectionDTO s){
        return sectionService.add(s);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable ("id") long id){
        if(sectionService.delete(id)){
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public SectionDTO update(@PathVariable ("id") long id,
                             @RequestBody SectionDTO s){
        return sectionService.update(id,s);
    }
}
