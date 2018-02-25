package com.spp.chekh.pmfrontend.dto;

import java.util.Objects;

public class LeagueDTO {

    private int countryId;
    private String name;

    public LeagueDTO() {
    }

    public LeagueDTO(int countryId, String name) {
        this.countryId = countryId;
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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
        LeagueDTO leagueDTO = (LeagueDTO) o;
        return countryId == leagueDTO.countryId &&
                Objects.equals(name, leagueDTO.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryId, name);
    }

    @Override
    public String toString() {
        return "LeagueDTO{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }
}
