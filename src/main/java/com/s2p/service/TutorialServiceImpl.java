package com.s2p.service;

import com.s2p.dao.ITutorialDAO;
import com.s2p.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TutorialServiceImpl implements ITutorialService{
    @Autowired
    ITutorialDAO tutorialDAO;
    @Override
    public List<Tutorial> getAll() {
        return tutorialDAO.findAll();
    }

    @Override
    public Tutorial add(Tutorial t) {
        return tutorialDAO.save(t);
    }
}
