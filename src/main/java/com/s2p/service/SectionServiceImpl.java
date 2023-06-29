package com.s2p.service;

import com.s2p.dao.ISectionRepository;
import com.s2p.dto.SectionDTO;
import com.s2p.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class SectionServiceImpl implements ISectionService {
    @Autowired
    ISectionRepository sectionRepository;


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

    public List<SectionDTO> ConvertListToDTO(List<Section> s){
        List<SectionDTO> s1 = new ArrayList<>();
        Iterator<Section> it = s.iterator();
        while(it.hasNext()){
            SectionDTO sq = ConvertSecToDTO(it.next());
            s1.add(sq);
        }
        return s1;
    }

    public List<Section> ConvertDTOToList(List<SectionDTO> s){
        List<Section> s1 = new ArrayList<>();
        Iterator<SectionDTO> it = s.iterator();
        while(it.hasNext()){
            Section sq = ConvertDTOtoSec(it.next());
            s1.add(sq);
        }
        return s1;
    }

    @Override
    public List<SectionDTO> getAll() {
        return ConvertListToDTO(sectionRepository.findAll());
    }

    @Override
    public SectionDTO add(SectionDTO s) {
        Section s1 = ConvertDTOtoSec(s);
        Section s2 = sectionRepository.save(s1);
        return ConvertSecToDTO(s2);
    }

    @Override
    public boolean delete(long id) {
        SectionDTO s = ConvertSecToDTO(sectionRepository.findById(id).get());
        if(s != null){
            sectionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SectionDTO update(long id,
                             SectionDTO s){
        Section s1 = sectionRepository.findById(id).get();
        if(s1 != null){
            if(s.getSectionname() != null){
                s1.setSectionname(s.getSectionname());
            }if(s.getSectiondescription() != null){
                s1.setSectiondescription(s.getSectiondescription());
            }
            s1.setShowinnavbar(s.isShowinnavbar());

        }
        return ConvertSecToDTO(sectionRepository.save(s1));
    }
}
