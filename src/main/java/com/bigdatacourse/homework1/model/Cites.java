package com.bigdatacourse.homework1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CitesPK.class)
public class Cites {
    private Integer paperidfrom;
    private Integer paperidto;

    @Id
    @Column(name = "paperidfrom")
    public Integer getPaperidfrom() {
        return paperidfrom;
    }

    public void setPaperidfrom(Integer paperidfrom) {
        this.paperidfrom = paperidfrom;
    }

    @Id
    @Column(name = "paperidto")
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

        Cites cites = (Cites) o;

        if (paperidfrom != null ? !paperidfrom.equals(cites.paperidfrom) : cites.paperidfrom != null) return false;
        if (paperidto != null ? !paperidto.equals(cites.paperidto) : cites.paperidto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paperidfrom != null ? paperidfrom.hashCode() : 0;
        result = 31 * result + (paperidto != null ? paperidto.hashCode() : 0);
        return result;
    }
}
