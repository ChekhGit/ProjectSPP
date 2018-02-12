package com.spp.chekh.pmfrontend.view.model.entity;

public class PlayerViewModel {

    private String id;
    private String name;
    private String surname;
    private String team;
    private String position;
    private String idPlayerStatistic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdPlayerStatistic() {
        return idPlayerStatistic;
    }

    public void setIdPlayerStatistic(String idPlayerStatistic) {
        this.idPlayerStatistic = idPlayerStatistic;
    }

    @Override
    public String toString() {
        return "PlayerViewModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                ", idPlayerStatistic='" + idPlayerStatistic + '\'' +
                '}';
    }
}
