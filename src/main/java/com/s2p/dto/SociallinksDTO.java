package com.s2p.dto;

public class SociallinksDTO {
    private long id;
    private String linktype;
    private String linkurl;
    private String linkiconurl;

    @Override
    public String toString() {
        return "SociallinksDTO{" +
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

    public SociallinksDTO(long id, String linktype, String linkurl, String linkiconurl) {
        this.id = id;
        this.linktype = linktype;
        this.linkurl = linkurl;
        this.linkiconurl = linkiconurl;
    }

    public SociallinksDTO() {
    }
}
