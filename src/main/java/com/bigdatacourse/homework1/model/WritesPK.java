package com.bigdatacourse.homework1.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class WritesPK implements Serializable {
    private Integer authorid;
    private Integer paperid;

    @Column(name = "authorid")
    @Id
    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    @Column(name = "paperid")
    @Id
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

        WritesPK writesPK = (WritesPK) o;

        if (authorid != null ? !authorid.equals(writesPK.authorid) : writesPK.authorid != null) return false;
        if (paperid != null ? !paperid.equals(writesPK.paperid) : writesPK.paperid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorid != null ? authorid.hashCode() : 0;
        result = 31 * result + (paperid != null ? paperid.hashCode() : 0);
        return result;
    }
}
