package com.s2p.service;

import com.s2p.dao.ICommentDAO;
import com.s2p.dao.ITutorialDAO;
import com.s2p.model.Comment;
import com.s2p.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService{
    @Autowired
    ICommentDAO commentDAO;
    @Autowired
    ITutorialDAO tutorialDAO;
    @Override
    public List<Comment> getAll() {
        return commentDAO.findAll();
    }

    @Override
    public Comment add(long tutorial_id,Comment t) {
        System.out.println(t);
        Tutorial t1 = (Tutorial)tutorialDAO.findById(tutorial_id).get();
        t.setTutorial(t1);
        return commentDAO.save(t);
    }
}
