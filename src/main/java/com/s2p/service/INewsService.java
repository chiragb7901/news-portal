package com.s2p.service;

import com.s2p.dto.NewsDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface INewsService {
    public List<NewsDTO> getAll();
    public NewsDTO add(NewsDTO n);
    public boolean delete(long id);
    public NewsDTO update(long id, NewsDTO n);
}
