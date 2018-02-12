package com.spp.chekh.pmfrontend.view.model.entity;

public class TeamViewModel {

    private String id;
    private String league;
    private String name;
    private String amountOfPlayers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
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

    @Override
    public String toString() {
        return "TeamViewModel{" +
                "id='" + id + '\'' +
                ", league='" + league + '\'' +
                ", name='" + name + '\'' +
                ", amountOfPlayers='" + amountOfPlayers + '\'' +
                '}';
    }
}
