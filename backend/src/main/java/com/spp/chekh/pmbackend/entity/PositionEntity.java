package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "position", schema = "football", catalog = "")
public class PositionEntity {
    private int id;
    private String name;
    private Collection<PlayerEntity> playersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 8)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionEntity that = (PositionEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "positionByIdPosition")
    public Collection<PlayerEntity> getPlayersById() {
        return playersById;
    }

    public void setPlayersById(Collection<PlayerEntity> playersById) {
        this.playersById = playersById;
    }
}
