package com.s2p.dto;

import com.s2p.model.News;

import java.util.Date;

public class NewsimageDTO {
    private long id;
    private String imageurl;
    private NewsDTO newsDTO;
    private Date createdOn;
    private Date modifiedOn;

    @Override
    public String toString() {
        return "NewsimageDTO{" +
                "id=" + id +
                ", imageurl='" + imageurl + '\'' +
                ", news=" + newsDTO +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public NewsDTO getNewsDTO() {
        return newsDTO;
    }

    public void setNewsDTO(NewsDTO newsDTO) {
        this.newsDTO = newsDTO;
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

    public NewsimageDTO(Long id, String imageurl, NewsDTO newsDTO, Date createdOn, Date modifiedOn) {
        this.id = id;
        this.imageurl = imageurl;
        this.newsDTO = newsDTO;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public NewsimageDTO() {
    }
}
