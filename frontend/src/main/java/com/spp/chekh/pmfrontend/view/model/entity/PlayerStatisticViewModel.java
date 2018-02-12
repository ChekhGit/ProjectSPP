package com.spp.chekh.pmfrontend.view.model.entity;

public class PlayerStatisticViewModel {

    private String id;
    private String lostMatches;
    private String winMatches;
    private String drawMatches;
    private String goals;
    private String keyPasses;
    private String redCards;
    private String yellowCards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(String lostMatches) {
        this.lostMatches = lostMatches;
    }

    public String getWinMatches() {
        return winMatches;
    }

    public void setWinMatches(String winMatches) {
        this.winMatches = winMatches;
    }

    public String getDrawMatches() {
        return drawMatches;
    }

    public void setDrawMatches(String drawMatches) {
        this.drawMatches = drawMatches;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getKeyPasses() {
        return keyPasses;
    }

    public void setKeyPasses(String keyPasses) {
        this.keyPasses = keyPasses;
    }

    public String getRedCards() {
        return redCards;
    }

    public void setRedCards(String redCards) {
        this.redCards = redCards;
    }

    public String getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(String yellowCards) {
        this.yellowCards = yellowCards;
    }

    @Override
    public String toString() {
        return "PlayerStatisticViewModel{" +
                "id='" + id + '\'' +
                ", lostMatches='" + lostMatches + '\'' +
                ", winMatches='" + winMatches + '\'' +
                ", drawMatches='" + drawMatches + '\'' +
                ", goals='" + goals + '\'' +
                ", keyPasses='" + keyPasses + '\'' +
                ", redCards='" + redCards + '\'' +
                ", yellowCards='" + yellowCards + '\'' +
                '}';
    }
}
