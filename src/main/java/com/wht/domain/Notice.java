package com.wht.domain;

import java.io.Serializable;

public class Notice implements Serializable {
    private Integer nId;
    private String title;
    private String details;
    private String nTime;

    @Override
    public String toString() {
        return "Notice{" +
                "nId=" + nId +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", nTime='" + nTime + '\'' +
                '}';
    }

    public Notice() {
    }

    public Notice(Integer nId, String title, String details, String nTime) {
        this.nId = nId;
        this.title = title;
        this.details = details;
        this.nTime = nTime;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getnTime() {
        return nTime;
    }

    public void setnTime(String nTime) {
        this.nTime = nTime;
    }
}
