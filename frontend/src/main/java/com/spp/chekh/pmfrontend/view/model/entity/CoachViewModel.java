package com.spp.chekh.pmfrontend.view.model.entity;

public class CoachViewModel {

    private String id;
    private String name;
    private String surname;
    private String yearsOld;
    private String idTeam;
    private String idStatistic;

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

    public String getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(String yearsOld) {
        this.yearsOld = yearsOld;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getIdStatistic() {
        return idStatistic;
    }

    public void setIdStatistic(String idStatistic) {
        this.idStatistic = idStatistic;
    }

    @Override
    public String toString() {
        return "CoachViewModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearsOld='" + yearsOld + '\'' +
                ", idTeam='" + idTeam + '\'' +
                ", idStatistic='" + idStatistic + '\'' +
                '}';
    }
}
