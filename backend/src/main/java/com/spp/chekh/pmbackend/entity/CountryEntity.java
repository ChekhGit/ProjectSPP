package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "country", schema = "football", catalog = "")
public class CountryEntity {
    private int id;
    private String name;
    private String url;
    private Collection<LeagueEntity> leaguesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 256)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, url);
    }

    @OneToMany(mappedBy = "countryByIdCountry")
    public Collection<LeagueEntity> getLeaguesById() {
        return leaguesById;
    }

    public void setLeaguesById(Collection<LeagueEntity> leaguesById) {
        this.leaguesById = leaguesById;
    }
}
