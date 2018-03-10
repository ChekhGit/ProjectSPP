package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "target_distribution", schema = "football", catalog = "")
public class TargetDistributionEntity {
    private int id;
    private String email;
    private String target;
    private int idTarget;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "target", nullable = false, length = 45)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "id_target", nullable = false)
    public int getIdTarget() {
        return idTarget;
    }

    public void setIdTarget(int idTarget) {
        this.idTarget = idTarget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetDistributionEntity that = (TargetDistributionEntity) o;
        return id == that.id &&
                idTarget == that.idTarget &&
                Objects.equals(email, that.email) &&
                Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, target, idTarget);
    }
}
