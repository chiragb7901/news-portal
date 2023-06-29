package com.s2p.service;

import com.s2p.dao.INewsRepository;
import com.s2p.dao.INewsimageRepository;
import com.s2p.dao.ISectionRepository;
import com.s2p.dto.NewsDTO;
import com.s2p.dto.NewsimageDTO;
import com.s2p.dto.SectionDTO;
import com.s2p.model.News;
import com.s2p.model.Newsimage;
import com.s2p.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class NewsimageServiceImpl implements INewsimageService{
    @Autowired
    INewsimageRepository newsimageRepository;

    @Autowired
    INewsRepository newsRepository;

    @Autowired
    ISectionRepository sectionRepository;


    public NewsimageDTO ConvertNewsimgToDTO(Newsimage n){
        NewsimageDTO n1 = new NewsimageDTO();
        n1.setId(n.getId());
        n1.setNewsDTO(ConvertNewsToDTO(n.getNews()));
        n1.setCreatedOn(n.getCreatedOn());
        n1.setModifiedOn(n.getModifiedOn());
        n1.setImageurl(n.getImageurl());
        return n1;
    }
    public Newsimage ConvertDTOToNewsimg(NewsimageDTO n){
        Newsimage n1 = new Newsimage();
        n1.setId(n.getId());
        n1.setNews(ConvertDTOToNews(n.getNewsDTO()));
        n1.setCreatedOn(n.getCreatedOn());
        n1.setModifiedOn(n.getModifiedOn());
        n1.setImageurl(n.getImageurl());
        return n1;
    }
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

    public List<NewsimageDTO> ConvertListToDTO(List<Newsimage> n){
        List<NewsimageDTO> n1 = new ArrayList<>();
        Iterator<Newsimage> it = n.iterator();
        while(it.hasNext()){
            NewsimageDTO nq = ConvertNewsimgToDTO(it.next());
            n1.add(nq);
        }
        return n1;
    }

    public List<Newsimage> ConvertDTOToList(List<NewsimageDTO> n){
        List<Newsimage> n1 = new ArrayList<>();
        Iterator<NewsimageDTO> it = n.iterator();
        while(it.hasNext()){
            Newsimage nq = ConvertDTOToNewsimg(it.next());
            n1.add(nq);
        }
        return n1;
    }

    @Override
    public List<NewsimageDTO> getAll() {
        return ConvertListToDTO(newsimageRepository.findAll());
    }

    @Override
    public NewsimageDTO add(NewsimageDTO n){
        Newsimage n1 = ConvertDTOToNewsimg(n);
        NewsDTO news1 = ConvertNewsToDTO(n1.getNews());
        long nID = news1.getId();
        NewsDTO news2 = ConvertNewsToDTO(newsRepository.findById(nID).get());
//        SectionDTO sec1 = news2.getSectionDTO();
//        long sId = sec1.getId();
//        SectionDTO sec2 = ConvertSecToDTO(sectionRepository.findById(sId).get());
//        news2.setSectionDTO(sec2);
        n1.setNews(ConvertDTOToNews(news2));
        Newsimage n2 = newsimageRepository.save(n1);
        return ConvertNewsimgToDTO(n2);
    }

    @Override
    public boolean delete(long id) {
        NewsimageDTO n = ConvertNewsimgToDTO(newsimageRepository.findById(id).get());
        if(n != null){
            newsimageRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public NewsimageDTO update(long id, NewsimageDTO n) {
        Newsimage n1 = newsimageRepository.findById(id).get();

        if(n1 != null){
            if(n.getNewsDTO() != null){
                NewsDTO s1  = n.getNewsDTO();
                long nId = s1.getId();
                NewsDTO s2 = ConvertNewsToDTO(newsRepository.findById(nId).get()) ;
                n1.setNews(ConvertDTOToNews(s2));
            }
            if(n.getImageurl() != null){
                n1.setImageurl(n.getImageurl());
            }
        }
        return ConvertNewsimgToDTO(newsimageRepository.save(n1));
    }
}
