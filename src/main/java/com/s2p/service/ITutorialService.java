package com.s2p.service;

import com.s2p.model.Tutorial;
import java.util.List;
public interface ITutorialService {
    public List<Tutorial> getAll();
    public Tutorial add(Tutorial t);

}
