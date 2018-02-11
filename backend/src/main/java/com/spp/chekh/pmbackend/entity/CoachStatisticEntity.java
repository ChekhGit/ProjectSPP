package com.spp.chekh.pmbackend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "coach_statistic", schema = "football", catalog = "")
public class CoachStatisticEntity {
    private int id;
    private int titles;
    private int winMatches;
    private int lostMatches;
    private int drawMatches;
    private Collection<CoachEntity> coachesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "titles", nullable = false)
    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
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
    @Column(name = "lost_matches", nullable = false)
    public int getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    @Basic
    @Column(name = "draw_matches", nullable = false)
    public int getDrawMatches() {
        return drawMatches;
    }

    public void setDrawMatches(int drawMatches) {
        this.drawMatches = drawMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachStatisticEntity that = (CoachStatisticEntity) o;
        return id == that.id &&
                titles == that.titles &&
                winMatches == that.winMatches &&
                lostMatches == that.lostMatches &&
                drawMatches == that.drawMatches;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, titles, winMatches, lostMatches, drawMatches);
    }

    @OneToMany(mappedBy = "coachStatisticByIdStatistic")
    public Collection<CoachEntity> getCoachesById() {
        return coachesById;
    }

    public void setCoachesById(Collection<CoachEntity> coachesById) {
        this.coachesById = coachesById;
    }
}
