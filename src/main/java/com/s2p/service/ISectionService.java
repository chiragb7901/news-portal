package com.s2p.service;

import com.s2p.dto.SectionDTO;

import java.util.List;
import java.util.Map;

public interface ISectionService {
    public List<SectionDTO> getAll();
    public SectionDTO add(SectionDTO s);
    public boolean delete(long id);
    public SectionDTO update( long id,
                              SectionDTO s);
}
