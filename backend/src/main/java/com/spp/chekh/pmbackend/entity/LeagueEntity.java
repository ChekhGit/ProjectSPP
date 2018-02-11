package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "league", schema = "football", catalog = "")
public class LeagueEntity {
    private int id;
    private int idCountry;
    private String name;
    private CountryEntity countryByIdCountry;
    private Collection<TeamEntity> teamsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_country", nullable = false,  insertable = false, updatable = false)
    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
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
        LeagueEntity that = (LeagueEntity) o;
        return id == that.id &&
                idCountry == that.idCountry &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idCountry, name);
    }

    @ManyToOne
    @JoinColumn(name = "id_country", referencedColumnName = "id", nullable = false)
    public CountryEntity getCountryByIdCountry() {
        return countryByIdCountry;
    }

    public void setCountryByIdCountry(CountryEntity countryByIdCountry) {
        this.countryByIdCountry = countryByIdCountry;
    }

    @OneToMany(mappedBy = "leagueByIdLeague")
    public Collection<TeamEntity> getTeamsById() {
        return teamsById;
    }

    public void setTeamsById(Collection<TeamEntity> teamsById) {
        this.teamsById = teamsById;
    }
}
