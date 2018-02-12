package com.spp.chekh.pmfrontend.view.model.entity;

public class TeamViewModel {

    private String id;
    private String idLeague;
    private String name;
    private String amountOfPlayers;

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

    public String getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(String amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    @Override
    public String toString() {
        return "TeamViewModel{" +
                "id='" + id + '\'' +
                ", idLeague='" + idLeague + '\'' +
                ", name='" + name + '\'' +
                ", amountOfPlayers='" + amountOfPlayers + '\'' +
                '}';
    }
}
