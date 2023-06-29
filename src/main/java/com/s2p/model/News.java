package com.s2p.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
    @Column(length = 200)
    private String videourl;
    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "createdOn", nullable = false, updatable = false)
    private Date createdOn;


    @UpdateTimestamp
    @Column(name = "modifiedOn")
    private Date modifiedOn;
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", section=" + section +
                ", videourl='" + videourl + '\'' +
                ", content='" + content + '\'' +
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public News(long id, Section section, String videourl, String content, Date createdOn, Date modifiedOn) {
        this.id = id;
        this.section = section;
        this.videourl = videourl;
        this.content = content;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public News() {
    }
}
