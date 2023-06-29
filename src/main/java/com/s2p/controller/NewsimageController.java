package com.s2p.controller;

import com.s2p.dto.NewsimageDTO;
import com.s2p.model.Newsimage;
import com.s2p.service.INewsimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/newsimage")
public class NewsimageController {
    @Autowired
    INewsimageService newsimageService;

    @GetMapping("/getAll")
    public List<NewsimageDTO> getAll(){
        return newsimageService.getAll();
    }

    @PostMapping("/add")
    public NewsimageDTO add(@RequestBody NewsimageDTO n){
        return newsimageService.add(n);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable ("id") long id){
        if(newsimageService.delete(id)){
            return true;
        }
        return false;
    }
    @PutMapping("/update/{id}")
    public NewsimageDTO udpate(@PathVariable ("id") long id,
                               @RequestBody NewsimageDTO n){
        return newsimageService.update(id,n);
    }
}
