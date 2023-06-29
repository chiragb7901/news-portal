package com.s2p.controller;

import com.s2p.dto.NewsDTO;
import com.s2p.model.News;
import com.s2p.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    INewsService newsService;

    @GetMapping("/getAll")
    public List<NewsDTO> getAll(){
        return newsService.getAll();
    }

    @PostMapping("/add")
    public NewsDTO add(@RequestBody NewsDTO n){
        return newsService.add(n);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable ("id") long id){
        if(newsService.delete(id)){
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public NewsDTO update(@PathVariable ("id") long id,
                          @RequestBody NewsDTO n){
        return  newsService.update(id,n);
    }

}
