package com.s2p.model;

import javax.persistence.*;

@Entity
@Table(name = "sociallinks")
public class Sociallinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 100,nullable = false)
    private String linktype;
    @Column(length = 200,nullable = false)
    private String linkurl;
    @Column(length = 200,nullable = false)
    private String linkiconurl;

    @Override
    public String toString() {
        return "Socaillinks{" +
                "id=" + id +
                ", linktype='" + linktype + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", linkiconurl='" + linkiconurl + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinktype() {
        return linktype;
    }

    public void setLinktype(String linktype) {
        this.linktype = linktype;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public String getLinkiconurl() {
        return linkiconurl;
    }

    public void setLinkiconurl(String linkiconurl) {
        this.linkiconurl = linkiconurl;
    }

    public Sociallinks(long id, String linktype, String linkurl, String linkiconurl) {
        this.id = id;
        this.linktype = linktype;
        this.linkurl = linkurl;
        this.linkiconurl = linkiconurl;
    }

    public Sociallinks() {
    }
}
