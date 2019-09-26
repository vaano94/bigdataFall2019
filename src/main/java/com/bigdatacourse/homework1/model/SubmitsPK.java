package com.bigdatacourse.homework1.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SubmitsPK implements Serializable {
    private Integer paperid;
    private Integer confid;

    @Column(name = "paperid")
    @Id
    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    @Column(name = "confid")
    @Id
    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubmitsPK submitsPK = (SubmitsPK) o;

        if (paperid != null ? !paperid.equals(submitsPK.paperid) : submitsPK.paperid != null) return false;
        if (confid != null ? !confid.equals(submitsPK.confid) : submitsPK.confid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paperid != null ? paperid.hashCode() : 0;
        result = 31 * result + (confid != null ? confid.hashCode() : 0);
        return result;
    }
}
