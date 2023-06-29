package com.s2p.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 100,nullable = false,unique = true)
    private String sectionname;
    @Column(length = 1000)
    private String sectiondescription;
    @Column(nullable = false)
    private boolean showinnavbar;


    @CreationTimestamp
    @Column(name = "createdOn", nullable = false, updatable = false)
    private Date createdOn;


    @UpdateTimestamp
    @Column(name = "modifiedOn")
    private Date modifiedOn;

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", sectionname='" + sectionname + '\'' +
                ", sectiondescription='" + sectiondescription + '\'' +
                ", showinnavbar=" + showinnavbar +
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

    public void setId(Long id) {
        this.id = id;
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

    public Section(long id, String sectionname, String sectiondescription, boolean showinnavbar, Date createdOn, Date modifiedOn) {
        this.id = id;
        this.sectionname = sectionname;
        this.sectiondescription = sectiondescription;
        this.showinnavbar = showinnavbar;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Section() {
    }
}
