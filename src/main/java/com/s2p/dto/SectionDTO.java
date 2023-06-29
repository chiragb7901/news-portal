package com.s2p.dto;

import java.util.Date;

public class SectionDTO {
    private long id;
    private String sectionname;
    private String sectiondescription;
    private boolean showinnavbar;
    private Date createdOn;
    private Date modifiedOn;

    @Override
    public String toString() {
        return "SectionDTO{" +
                "id=" + id +
                ", sectionname='" + sectionname + '\'' +
                ", sectiondescription='" + sectiondescription + '\'' +
                ", showinnavbar=" + showinnavbar +
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

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public String getSectiondescription() {
        return sectiondescription;
    }

    public void setSectiondescription(String sectiondescription) {
        this.sectiondescription = sectiondescription;
    }

    public boolean isShowinnavbar() {
        return showinnavbar;
    }

    public void setShowinnavbar(boolean showinnavbar) {
        this.showinnavbar = showinnavbar;
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

    public SectionDTO(Long id, String sectionname, String sectiondescription, boolean showinnavbar, Date createdOn, Date modifiedOn) {
        this.id = id;
        this.sectionname = sectionname;
        this.sectiondescription = sectiondescription;
        this.showinnavbar = showinnavbar;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public SectionDTO() {
    }
}
