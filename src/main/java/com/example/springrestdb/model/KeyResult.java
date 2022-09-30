package com.example.springrestdb.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name= "KeyResult.findByIdLessOrSameThat", query = "select kr from KeyResult kr where kr.id<=?1")
@NamedQuery(name= "KeyResult.countKeyResultsForTheAssociatedObjective", query = "select count(kr) from KeyResult kr where kr.objective=(select ckr.objective from KeyResult ckr where ckr.id=?1)")
@NamedNativeQuery(name= "KeyResult.count", query = "select count(*) from key_result as kr where kr.objective_id=?")
@NamedNativeQuery(name= "KeyResult.findByIdGreaterThat", query = "select * from key_result as kr where kr.id>?", resultClass = KeyResult.class)
@NamedNativeQuery(name= "KeyResult.countKeyResultsForTheAssociatedObjectiveNative", query = "select count(*) from key_result as kr where kr.objective_id=(select objective_id from key_result where key_result.id=?)")
public class KeyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int measurment;

    public long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "objective_id", foreignKey = @ForeignKey(name = "OBJECTIVE_ID_FK"))
    private Objective objective;

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMeasurment() {
        return measurment;
    }

    public void setMeasurment(int measurment) {
        this.measurment = measurment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyResult compareObjective = (KeyResult) o;
        return id == compareObjective.id && Objects.equals(name, compareObjective.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "KeyResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

