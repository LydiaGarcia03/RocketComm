package br.com.lauratobiasf.rocketcommversao2.DataObjectLayer;

import java.io.Serializable;

public class Rocket implements Serializable {

    int id;
    String rocket_name;
    String creation_date;
    float rocket_height;
    float rocket_weight;
    int stages;
    String rocket_description;

    public Rocket(int id, String name)
    {
        this.id = id;
        this.rocket_name = name;
    }

    public Rocket(int id, String rocket_name, String creation_date, float rocket_height, float rocket_weight, int stages, String rocket_description) {
        this.id = id;
        this.rocket_name = rocket_name;
        this.creation_date = creation_date;
        this.rocket_height = rocket_height;
        this.rocket_weight = rocket_weight;
        this.stages = stages;
        this.rocket_description = rocket_description;
    }
    public Rocket(String rocket_name, String creation_date, float rocket_height, float rocket_weight, int stages, String rocket_description) {
        this.rocket_name = rocket_name;
        this.creation_date = creation_date;
        this.rocket_height = rocket_height;
        this.rocket_weight = rocket_weight;
        this.stages = stages;
        this.rocket_description = rocket_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public float getRocket_height() {
        return rocket_height;
    }

    public void setRocket_height(float rocket_height) {
        this.rocket_height = rocket_height;
    }

    public float getRocket_weight() {
        return rocket_weight;
    }

    public void setRocket_weight(float rocket_weight) {
        this.rocket_weight = rocket_weight;
    }

    public int getStages() {
        return stages;
    }

    public void setStages(int stages) {
        this.stages = stages;
    }

    public String getRocket_description() {
        return rocket_description;
    }

    public void setRocket_description(String rocket_description) {
        this.rocket_description = rocket_description;
    }
}
