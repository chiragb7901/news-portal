package com.s2p.service;

import com.s2p.dao.INewsRepository;
import com.s2p.dao.ISectionRepository;
import com.s2p.dto.NewsDTO;
import com.s2p.dto.SectionDTO;
import com.s2p.model.News;
import com.s2p.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class NewsServiceImpl implements INewsService{
    @Autowired
    INewsRepository newsRepository;

    @Autowired
    ISectionRepository sectionRepository;


    public NewsDTO ConvertNewsToDTO(News n){
        NewsDTO n1 = new NewsDTO();
        n1.setId(n.getId());
        n1.setCreatedOn(n.getCreatedOn());
        n1.setModifiedOn(n.getModifiedOn());
        n1.setContent(n.getContent());
        n1.setVideourl(n.getVideourl());
        n1.setSectionDTO(ConvertSecToDTO(n.getSection()));
        return n1;
    }

    public News ConvertDTOToNews(NewsDTO n){
        News n1 = new News();
        n1.setId(n.getId());
        n1.setCreatedOn(n.getCreatedOn());
        n1.setModifiedOn(n.getModifiedOn());
        n1.setContent(n.getContent());
        n1.setVideourl(n.getVideourl());
        n1.setSection(ConvertDTOtoSec(n.getSectionDTO()));
        return n1;
    }
    public SectionDTO ConvertSecToDTO(Section s){
        SectionDTO s1 =  new SectionDTO();
        s1.setId(s.getId());
        s1.setCreatedOn(s.getCreatedOn());
        s1.setModifiedOn(s.getModifiedOn());
        s1.setSectiondescription(s.getSectiondescription());
        s1.setSectionname(s.getSectionname());
        s1.setShowinnavbar(s.isShowinnavbar());
        return s1;
    }
    public Section ConvertDTOtoSec(SectionDTO s){
        Section s1 =  new Section();
        s1.setId(s.getId());
        s1.setCreatedOn(s.getCreatedOn());
        s1.setModifiedOn(s.getModifiedOn());
        s1.setSectiondescription(s.getSectiondescription());
        s1.setSectionname(s.getSectionname());
        s1.setShowinnavbar(s.isShowinnavbar());
        return s1;
    }

    public List<NewsDTO> ConvertListToDTO(List<News> n){
        List<NewsDTO> n1 = new ArrayList<>();
        Iterator<News> it = n.iterator();
        while(it.hasNext()){
            NewsDTO nq = ConvertNewsToDTO(it.next());
            n1.add(nq);
        }
        return n1;
    }
    public List<News> ConvertDTOToList(List<NewsDTO> n){
        List<News> n1 = new ArrayList<>();
        Iterator<NewsDTO> it = n.iterator();
        while(it.hasNext()){
            News nq = ConvertDTOToNews(it.next());
            n1.add(nq);
        }
        return n1;
    }
    @Override
    public List<NewsDTO> getAll() {
        return ConvertListToDTO(newsRepository.findAll());
    }

    @Override
    public NewsDTO add(NewsDTO n) {
        News n1 = ConvertDTOToNews(n);
        SectionDTO s1  = n.getSectionDTO();
        long sId = s1.getId();
        SectionDTO s2 = ConvertSecToDTO(sectionRepository.findById(sId).get());

        n1.setSection(ConvertDTOtoSec(s2));
        News n2 = newsRepository.save(n1);
        return ConvertNewsToDTO(n2);
    }

    @Override
    public boolean delete(long id) {
        NewsDTO n = ConvertNewsToDTO(newsRepository.findById(id).get());
        if(n != null){
            newsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public NewsDTO update(long id, NewsDTO n) {
        News n1 = newsRepository.findById(id).get();
        if(n1 != null){
            if(n.getContent() != null){
                n1.setContent(n.getContent());;
            }
            if(n.getVideourl() != null){
                n1.setVideourl(n.getVideourl());
            }
            if(n.getSectionDTO() != null){
                SectionDTO s1  = n.getSectionDTO();
                long sId = s1.getId();
                SectionDTO s2 = ConvertSecToDTO(sectionRepository.findById(sId).get());
                n1.setSection(ConvertDTOtoSec(s2));
            }
        }
        return ConvertNewsToDTO(newsRepository.save(n1));
    }

}
