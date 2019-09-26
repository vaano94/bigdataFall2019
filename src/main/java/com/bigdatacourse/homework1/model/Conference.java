package com.bigdatacourse.homework1.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Conference {
    private Integer confid;
    private String name;
    private BigInteger ranking;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "confid")
    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ranking")
    public BigInteger getRanking() {
        return ranking;
    }

    public void setRanking(BigInteger ranking) {
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conference that = (Conference) o;

        if (confid != null ? !confid.equals(that.confid) : that.confid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ranking != null ? !ranking.equals(that.ranking) : that.ranking != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = confid != null ? confid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ranking != null ? ranking.hashCode() : 0);
        return result;
    }
}
