package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coach", schema = "football", catalog = "")
public class CoachEntity {
    private int id;
    private String name;
    private int yearsOld;
    private String surname;
    private int idStatistic;
    private int idTeam;
    private CoachStatisticEntity coachStatisticByIdStatistic;
    private TeamEntity teamByIdTeam;

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
    @Column(name = "years_old", nullable = false)
    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 128)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "id_statistic", nullable = false, insertable = false, updatable = false)
    public int getIdStatistic() {
        return idStatistic;
    }

    public void setIdStatistic(int idStatistic) {
        this.idStatistic = idStatistic;
    }

    @Basic
    @Column(name = "id_team", nullable = false, insertable = false, updatable = false)
    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachEntity that = (CoachEntity) o;
        return id == that.id &&
                yearsOld == that.yearsOld &&
                idStatistic == that.idStatistic &&
                idTeam == that.idTeam &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, yearsOld, surname, idStatistic, idTeam);
    }

    @ManyToOne
    @JoinColumn(name = "id_statistic", referencedColumnName = "id", nullable = false)
    public CoachStatisticEntity getCoachStatisticByIdStatistic() {
        return coachStatisticByIdStatistic;
    }

    public void setCoachStatisticByIdStatistic(CoachStatisticEntity coachStatisticByIdStatistic) {
        this.coachStatisticByIdStatistic = coachStatisticByIdStatistic;
    }

    @ManyToOne
    @JoinColumn(name = "id_team", referencedColumnName = "id", nullable = false)
    public TeamEntity getTeamByIdTeam() {
        return teamByIdTeam;
    }

    public void setTeamByIdTeam(TeamEntity teamByIdTeam) {
        this.teamByIdTeam = teamByIdTeam;
    }
}
