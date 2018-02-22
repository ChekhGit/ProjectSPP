package com.spp.chekh.pmfrontend.dto;

import java.util.Objects;

public class PlayerDTO {

    private String name;
    private String surname;
    private int idTeam;
    private int idPosition;
    private int lostMatches;
    private int winMatches;
    private int drawMatches;
    private int goals;
    private int keyPasses;
    private int redCards;
    private int yellowCards;

    public PlayerDTO() {
    }

    public PlayerDTO(String name, String surname, int idTeam, int idPosition, int lostMatches, int winMatches, int drawMatches, int goals, int keyPasses, int redCards, int yellowCards) {
        this.name = name;
        this.surname = surname;
        this.idTeam = idTeam;
        this.idPosition = idPosition;
        this.lostMatches = lostMatches;
        this.winMatches = winMatches;
        this.drawMatches = drawMatches;
        this.goals = goals;
        this.keyPasses = keyPasses;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
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

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    public int getWinMatches() {
        return winMatches;
    }

    public void setWinMatches(int winMatches) {
        this.winMatches = winMatches;
    }

    public int getDrawMatches() {
        return drawMatches;
    }

    public void setDrawMatches(int drawMatches) {
        this.drawMatches = drawMatches;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getKeyPasses() {
        return keyPasses;
    }

    public void setKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

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
        PlayerDTO playerDTO = (PlayerDTO) o;
        return idTeam == playerDTO.idTeam &&
                idPosition == playerDTO.idPosition &&
                lostMatches == playerDTO.lostMatches &&
                winMatches == playerDTO.winMatches &&
                drawMatches == playerDTO.drawMatches &&
                goals == playerDTO.goals &&
                keyPasses == playerDTO.keyPasses &&
                redCards == playerDTO.redCards &&
                yellowCards == playerDTO.yellowCards &&
                Objects.equals(name, playerDTO.name) &&
                Objects.equals(surname, playerDTO.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, idTeam, idPosition, lostMatches, winMatches, drawMatches, goals, keyPasses, redCards, yellowCards);
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idTeam=" + idTeam +
                ", idPosition=" + idPosition +
                ", lostMatches=" + lostMatches +
                ", winMatches=" + winMatches +
                ", drawMatches=" + drawMatches +
                ", goals=" + goals +
                ", keyPasses=" + keyPasses +
                ", redCards=" + redCards +
                ", yellowCards=" + yellowCards +
                '}';
    }
}
