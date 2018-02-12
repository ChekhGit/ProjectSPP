package com.spp.chekh.pmfrontend.view.model.entity;

public class PlayerViewModel {

    private String id;
    private String name;
    private String surname;
    private String idTeam;
    private String idPosition;
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

    public String getIdPlayerStatistic() {
        return idPlayerStatistic;
    }

    public void setIdPlayerStatistic(String idPlayerStatistic) {
        this.idPlayerStatistic = idPlayerStatistic;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(String idPosition) {
        this.idPosition = idPosition;
    }

    @Override
    public String toString() {
        return "PlayerViewModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idTeam='" + idTeam + '\'' +
                ", idPosition='" + idPosition + '\'' +
                ", idPlayerStatistic='" + idPlayerStatistic + '\'' +
                '}';
    }
}
