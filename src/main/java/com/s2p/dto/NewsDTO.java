package com.s2p.dto;

import com.s2p.model.Section;

import java.util.Date;

public class NewsDTO {
    private long id;
    private SectionDTO sectionDTO;
    private String videourl;
    private String content;
    private Date createdOn;
    private Date modifiedOn;

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id=" + id +
                ", section=" + sectionDTO +
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

    public SectionDTO getSectionDTO() {
        return sectionDTO;
    }

    public void setSectionDTO(SectionDTO sectionDTO) {
        this.sectionDTO = sectionDTO;
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

    public NewsDTO(long id, SectionDTO sectionDTO, String videourl, String content, Date createdOn, Date modifiedOn) {
        this.id = id;
        this.sectionDTO = sectionDTO;
        this.videourl = videourl;
        this.content = content;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public NewsDTO() {
    }
}
