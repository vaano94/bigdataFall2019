package com.bigdatacourse.homework1.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paper {
    private Integer paperid;
    private String title;
    private String extract;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paperid")
    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "extract")
    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paper paper = (Paper) o;

        if (paperid != null ? !paperid.equals(paper.paperid) : paper.paperid != null) return false;
        if (title != null ? !title.equals(paper.title) : paper.title != null) return false;
        if (extract != null ? !extract.equals(paper.extract) : paper.extract != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paperid != null ? paperid.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (extract != null ? extract.hashCode() : 0);
        return result;
    }
}
