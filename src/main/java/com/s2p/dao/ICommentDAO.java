package com.s2p.dao;

import com.s2p.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentDAO extends JpaRepository<Comment,Long> {
}
