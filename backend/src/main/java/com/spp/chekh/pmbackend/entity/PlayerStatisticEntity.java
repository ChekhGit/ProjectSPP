package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "player_statistic", schema = "football", catalog = "")
public class PlayerStatisticEntity {
    private int id;
    private int lostMatches;
    private int winMatches;
    private int drawMatches;
    private int goals;
    private int keyPasses;
    private int redCards;
    private int yellowCards;
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
    @Column(name = "lost_matches", nullable = false)
    public int getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    @Basic
    @Column(name = "win_matches", nullable = false)
    public int getWinMatches() {
        return winMatches;
    }

    public void setWinMatches(int winMatches) {
        this.winMatches = winMatches;
    }

    @Basic
    @Column(name = "draw_matches", nullable = false)
    public int getDrawMatches() {
        return drawMatches;
    }

    public void setDrawMatches(int drawMatches) {
        this.drawMatches = drawMatches;
    }

    @Basic
    @Column(name = "goals", nullable = false)
    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Basic
    @Column(name = "key_passes", nullable = false)
    public int getKeyPasses() {
        return keyPasses;
    }

    public void setKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

    @Basic
    @Column(name = "red_cards", nullable = false)
    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    @Basic
    @Column(name = "yellow_cards", nullable = false)
    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatisticEntity that = (PlayerStatisticEntity) o;
        return id == that.id &&
                lostMatches == that.lostMatches &&
                winMatches == that.winMatches &&
                drawMatches == that.drawMatches &&
                goals == that.goals &&
                keyPasses == that.keyPasses &&
                redCards == that.redCards &&
                yellowCards == that.yellowCards;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, lostMatches, winMatches, drawMatches, goals, keyPasses, redCards, yellowCards);
    }

    @OneToMany(mappedBy = "playerStatisticByIdPlayerStat")
    public Collection<PlayerEntity> getPlayersById() {
        return playersById;
    }

    public void setPlayersById(Collection<PlayerEntity> playersById) {
        this.playersById = playersById;
    }
}
