package com.s2p.service;

import com.s2p.dto.NewsimageDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface INewsimageService {
    public List<NewsimageDTO> getAll();
    public NewsimageDTO add(NewsimageDTO n);
    public boolean delete(long id);
    public NewsimageDTO update(long id, NewsimageDTO n);
}
