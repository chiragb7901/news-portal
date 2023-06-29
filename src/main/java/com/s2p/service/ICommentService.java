package com.s2p.service;

import com.s2p.model.Comment;
import com.s2p.model.Tutorial;

import java.util.List;

public interface ICommentService {
    public List<Comment> getAll();
    public Comment add(long tutorial_id,Comment t);
}
