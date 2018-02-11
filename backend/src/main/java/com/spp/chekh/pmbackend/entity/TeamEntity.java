package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "team", schema = "football", catalog = "")
public class TeamEntity {
    private int id;
    private int idLeague;
    private String name;
    private int amountOfPlayers;
    private Collection<CoachEntity> coachesById;
    private Collection<PlayerEntity> playersById;
    private LeagueEntity leagueByIdLeague;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_league", nullable = false,  insertable = false, updatable = false)
    public int getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(int idLeague) {
        this.idLeague = idLeague;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "amount_of_players", nullable = false)
    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity that = (TeamEntity) o;
        return id == that.id &&
                idLeague == that.idLeague &&
                amountOfPlayers == that.amountOfPlayers &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idLeague, name, amountOfPlayers);
    }

    @OneToMany(mappedBy = "teamByIdTeam")
    public Collection<CoachEntity> getCoachesById() {
        return coachesById;
    }

    public void setCoachesById(Collection<CoachEntity> coachesById) {
        this.coachesById = coachesById;
    }

    @OneToMany(mappedBy = "teamByIdTeam")
    public Collection<PlayerEntity> getPlayersById() {
        return playersById;
    }

    public void setPlayersById(Collection<PlayerEntity> playersById) {
        this.playersById = playersById;
    }

    @ManyToOne
    @JoinColumn(name = "id_league", referencedColumnName = "id", nullable = false)
    public LeagueEntity getLeagueByIdLeague() {
        return leagueByIdLeague;
    }

    public void setLeagueByIdLeague(LeagueEntity leagueByIdLeague) {
        this.leagueByIdLeague = leagueByIdLeague;
    }
}
