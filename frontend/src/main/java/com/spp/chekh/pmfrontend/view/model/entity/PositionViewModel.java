package com.spp.chekh.pmfrontend.view.model.entity;

public class PositionViewModel {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PositionViewModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
