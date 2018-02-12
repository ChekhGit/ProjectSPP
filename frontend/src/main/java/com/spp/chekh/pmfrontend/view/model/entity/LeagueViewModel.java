package com.spp.chekh.pmfrontend.view.model.entity;

public class LeagueViewModel {

    private String id;
    private String idCountry;
    private String name;

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

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public String toString() {
        return "LeagueViewModel{" +
                "id='" + id + '\'' +
                ", idCountry='" + idCountry + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
