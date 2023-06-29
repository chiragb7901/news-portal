package com.s2p.service;

import com.s2p.dao.ISociallinksRepository;
import com.s2p.dto.SociallinksDTO;
import com.s2p.model.Sociallinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class SociallinksServiceImpl implements ISociallinksService{
    @Autowired
    ISociallinksRepository sociallinksRepository;

    public SociallinksDTO ConvertSocialToDTO(Sociallinks s){
        SociallinksDTO s1 = new SociallinksDTO();
        s1.setId(s.getId());
        s1.setLinkiconurl(s.getLinkiconurl());
        s1.setLinktype(s.getLinktype());
        s1.setLinkurl(s.getLinkurl());
        return s1;
    }
    public Sociallinks ConvertDTOToSocial(SociallinksDTO s){
        Sociallinks s1 = new Sociallinks();
        s1.setId(s.getId());
        s1.setLinkiconurl(s.getLinkiconurl());
        s1.setLinktype(s.getLinktype());
        s1.setLinkurl(s.getLinkurl());
        return s1;
    }
    public List<SociallinksDTO> ConvertListToDTO(List<Sociallinks> s){
        List<SociallinksDTO> s1 = new ArrayList<>();
        Iterator<Sociallinks> it = s.iterator();
        while(it.hasNext()){
            SociallinksDTO sq = ConvertSocialToDTO(it.next());
            s1.add(sq);
        }
        return s1;
    }

    public List<Sociallinks> ConvertDTOToList(List<SociallinksDTO> s){
        List<Sociallinks> s1 = new ArrayList<>();
        Iterator<SociallinksDTO> it = s.iterator();
        while(it.hasNext()){
            Sociallinks sq = ConvertDTOToSocial(it.next());
            s1.add(sq);
        }
        return s1;
    }
    @Override
    public List<SociallinksDTO> getAll() {
        return ConvertListToDTO(sociallinksRepository.findAll());
    }

    @Override
    public SociallinksDTO add(SociallinksDTO s) {
        Sociallinks s1 = ConvertDTOToSocial(s);
        Sociallinks s2 = sociallinksRepository.save(s1);
        return ConvertSocialToDTO(s2);
    }

    @Override
    public boolean delete(long id) {
        SociallinksDTO s = ConvertSocialToDTO(sociallinksRepository.findById(id).get());
        if(s != null){
            sociallinksRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SociallinksDTO update(long id, SociallinksDTO s){
        Sociallinks s1 = sociallinksRepository.findById(id).get();
        if( s1 != null){
            if(s.getLinkiconurl() != null){
                s1.setLinkiconurl(s.getLinkiconurl());
            }
            if(s.getLinkurl() != null){
                s1.setLinkurl(s.getLinkurl());
            }
            if(s.getLinktype() != null){
                s1.setLinktype(s.getLinktype());
            }
        }
        return ConvertSocialToDTO(sociallinksRepository.save(s1));
    };
}
