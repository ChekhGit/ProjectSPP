package com.spp.chekh.pmfrontend.view.model.entity;

public class CoachStatisticViewModel {

    private String id;
    private String titles;
    private String winMatches;
    private String lostMatches;
    private String drawMatches;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getWinMatches() {
        return winMatches;
    }

    public void setWinMatches(String winMatches) {
        this.winMatches = winMatches;
    }

    public String getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(String lostMatches) {
        this.lostMatches = lostMatches;
    }

    public String getDrawMatches() {
        return drawMatches;
    }

    public void setDrawMatches(String drawMatches) {
        this.drawMatches = drawMatches;
    }

    @Override
    public String toString() {
        return "CoachStatisticViewModel{" +
                "id='" + id + '\'' +
                ", titles='" + titles + '\'' +
                ", winMatches='" + winMatches + '\'' +
                ", lostMatches='" + lostMatches + '\'' +
                ", drawMatches='" + drawMatches + '\'' +
                '}';
    }
}
