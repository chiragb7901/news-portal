package com.s2p.controller;

import com.s2p.dto.SociallinksDTO;
import com.s2p.service.ISociallinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sociallinks")
public class SociallinksController {
    @Autowired
    ISociallinksService sociallinksService;

    @GetMapping("/getAll")
    public List<SociallinksDTO> getAll(){
        return sociallinksService.getAll();
    }

    @PostMapping("/add")
    public SociallinksDTO add(@RequestBody SociallinksDTO s){
        return sociallinksService.add(s);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable ("id") long id){
        if(sociallinksService.delete(id)){
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public SociallinksDTO update(@PathVariable ("id") long id,
                                 @RequestBody SociallinksDTO s){

        return sociallinksService.update(id,s);
    }
}
