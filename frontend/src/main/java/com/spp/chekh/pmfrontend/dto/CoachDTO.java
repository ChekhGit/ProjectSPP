package com.spp.chekh.pmfrontend.dto;

import java.util.Objects;

public class CoachDTO {

    private String name;
    private String surname;
    private int yearsOld;
    private int idTeam;
    private int titles;
    private int winMatches;
    private int lostMatches;
    private int drawMatches;

    public CoachDTO() {
    }

    public CoachDTO(String name, String surname, int yearsOld, int idTeam, int titles, int winMatches, int lostMatches, int drawMatches) {
        this.name = name;
        this.surname = surname;
        this.yearsOld = yearsOld;
        this.idTeam = idTeam;
        this.titles = titles;
        this.winMatches = winMatches;
        this.lostMatches = lostMatches;
        this.drawMatches = drawMatches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    public int getWinMatches() {
        return winMatches;
    }

    public void setWinMatches(int winMatches) {
        this.winMatches = winMatches;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

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
        CoachDTO coachDTO = (CoachDTO) o;
        return yearsOld == coachDTO.yearsOld &&
                idTeam == coachDTO.idTeam &&
                titles == coachDTO.titles &&
                winMatches == coachDTO.winMatches &&
                lostMatches == coachDTO.lostMatches &&
                drawMatches == coachDTO.drawMatches &&
                Objects.equals(name, coachDTO.name) &&
                Objects.equals(surname, coachDTO.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, yearsOld, idTeam, titles, winMatches, lostMatches, drawMatches);
    }

    @Override
    public String toString() {
        return "CoachDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearsOld=" + yearsOld +
                ", idTeam=" + idTeam +
                ", titles=" + titles +
                ", winMatches=" + winMatches +
                ", lostMatches=" + lostMatches +
                ", drawMatches=" + drawMatches +
                '}';
    }
}
