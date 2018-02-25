package com.spp.chekh.pmfrontend.dto;

import java.util.Objects;

public class TeamDTO {

    private int leagueId;
    private String name;

    public TeamDTO() {
    }

    public TeamDTO(int leagueId, String name) {
        this.leagueId = leagueId;
        this.name = name;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

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
        TeamDTO teamDTO = (TeamDTO) o;
        return leagueId == teamDTO.leagueId &&
                Objects.equals(name, teamDTO.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(leagueId, name);
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "leagueId=" + leagueId +
                ", name='" + name + '\'' +
                '}';
    }
}
