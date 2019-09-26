package com.bigdatacourse.homework1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(WritesPK.class)
public class Writes {
    private Integer authorid;
    private Integer paperid;

    @Id
    @Column(name = "authorid")
    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    @Id
    @Column(name = "paperid")
    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Writes writes = (Writes) o;

        if (authorid != null ? !authorid.equals(writes.authorid) : writes.authorid != null) return false;
        if (paperid != null ? !paperid.equals(writes.paperid) : writes.paperid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorid != null ? authorid.hashCode() : 0;
        result = 31 * result + (paperid != null ? paperid.hashCode() : 0);
        return result;
    }
}
