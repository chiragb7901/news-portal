package com.s2p.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "newsimage")
public class Newsimage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 200)
    private String imageurl;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private News news;

    @CreationTimestamp
    @Column(name = "createdOn", nullable = false, updatable = false)
    private Date createdOn;


    @UpdateTimestamp
    @Column(name = "modifiedOn")
    private Date modifiedOn;

    @Override
    public String toString() {
        return "Newsimage{" +
                "id=" + id +
                ", imageurl='" + imageurl + '\'' +
                ", news=" + news +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Newsimage(long id, String imageurl, News news, Date createdOn, Date modifiedOn) {
        this.id = id;
        this.imageurl = imageurl;
        this.news = news;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Newsimage() {
    }
}
