package com.bigdatacourse.homework1.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CitesPK implements Serializable {
    private Integer paperidfrom;
    private Integer paperidto;

    @Column(name = "paperidfrom")
    @Id
    public Integer getPaperidfrom() {
        return paperidfrom;
    }

    public void setPaperidfrom(Integer paperidfrom) {
        this.paperidfrom = paperidfrom;
    }

    @Column(name = "paperidto")
    @Id
    public Integer getPaperidto() {
        return paperidto;
    }

    public void setPaperidto(Integer paperidto) {
        this.paperidto = paperidto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitesPK citesPK = (CitesPK) o;

        if (paperidfrom != null ? !paperidfrom.equals(citesPK.paperidfrom) : citesPK.paperidfrom != null) return false;
        if (paperidto != null ? !paperidto.equals(citesPK.paperidto) : citesPK.paperidto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paperidfrom != null ? paperidfrom.hashCode() : 0;
        result = 31 * result + (paperidto != null ? paperidto.hashCode() : 0);
        return result;
    }
}
