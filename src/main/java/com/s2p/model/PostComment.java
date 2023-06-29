package com.s2p.model;

import javax.persistence.*;

@Entity
@Table(name="postcomment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
