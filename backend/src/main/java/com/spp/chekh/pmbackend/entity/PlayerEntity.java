package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player", schema = "football", catalog = "")
public class PlayerEntity {
    private int id;
    private String name;
    private String surname;
    private int idTeam;
    private int idPlayerStat;
    private int idPosition;
    private TeamEntity teamByIdTeam;
    private PlayerStatisticEntity playerStatisticByIdPlayerStat;
    private PositionEntity positionByIdPosition;

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
    @Column(name = "surname", nullable = false, length = 128)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "id_team", nullable = false,  insertable = false, updatable = false)
    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    @Basic
    @Column(name = "id_player_stat", nullable = false,  insertable = false, updatable = false)
    public int getIdPlayerStat() {
        return idPlayerStat;
    }

    public void setIdPlayerStat(int idPlayerStat) {
        this.idPlayerStat = idPlayerStat;
    }

    @Basic
    @Column(name = "id_position", nullable = false,  insertable = false, updatable = false)
    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return id == that.id &&
                idTeam == that.idTeam &&
                idPlayerStat == that.idPlayerStat &&
                idPosition == that.idPosition &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, idTeam, idPlayerStat, idPosition);
    }

    @ManyToOne
    @JoinColumn(name = "id_team", referencedColumnName = "id", nullable = false)
    public TeamEntity getTeamByIdTeam() {
        return teamByIdTeam;
    }

    public void setTeamByIdTeam(TeamEntity teamByIdTeam) {
        this.teamByIdTeam = teamByIdTeam;
    }

    @ManyToOne
    @JoinColumn(name = "id_player_stat", referencedColumnName = "id", nullable = false)
    public PlayerStatisticEntity getPlayerStatisticByIdPlayerStat() {
        return playerStatisticByIdPlayerStat;
    }

    public void setPlayerStatisticByIdPlayerStat(PlayerStatisticEntity playerStatisticByIdPlayerStat) {
        this.playerStatisticByIdPlayerStat = playerStatisticByIdPlayerStat;
    }

    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "id", nullable = false)
    public PositionEntity getPositionByIdPosition() {
        return positionByIdPosition;
    }

    public void setPositionByIdPosition(PositionEntity positionByIdPosition) {
        this.positionByIdPosition = positionByIdPosition;
    }
}
