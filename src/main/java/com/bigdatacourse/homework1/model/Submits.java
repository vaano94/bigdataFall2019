package com.bigdatacourse.homework1.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Date;

@Entity
@IdClass(SubmitsPK.class)
public class Submits {
    private Integer paperid;
    private Integer confid;
    private Boolean isaccepted;
    private Date date;

    @Id
    @Column(name = "paperid")
    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    @Id
    @Column(name = "confid")
    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    @Basic
    @Column(name = "isaccepted")
    public Boolean getIsaccepted() {
        return isaccepted;
    }

    public void setIsaccepted(Boolean isaccepted) {
        this.isaccepted = isaccepted;
    }

    @Basic
    @Column(name = "date_")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Submits submits = (Submits) o;

        if (paperid != null ? !paperid.equals(submits.paperid) : submits.paperid != null) return false;
        if (confid != null ? !confid.equals(submits.confid) : submits.confid != null) return false;
        if (isaccepted != null ? !isaccepted.equals(submits.isaccepted) : submits.isaccepted != null) return false;
        if (date != null ? !date.equals(submits.date) : submits.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paperid != null ? paperid.hashCode() : 0;
        result = 31 * result + (confid != null ? confid.hashCode() : 0);
        result = 31 * result + (isaccepted != null ? isaccepted.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
