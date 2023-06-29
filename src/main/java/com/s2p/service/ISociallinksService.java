package com.s2p.service;

import com.s2p.dto.SociallinksDTO;

import java.util.List;
import java.util.Map;

public interface ISociallinksService {
    public List<SociallinksDTO> getAll();
    public SociallinksDTO add(SociallinksDTO s);
    public boolean delete(long id);
    public SociallinksDTO update(long id, SociallinksDTO s);
}
