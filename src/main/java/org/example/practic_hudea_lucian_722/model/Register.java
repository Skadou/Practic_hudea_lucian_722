package org.example.practic_hudea_lucian_722.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.practic_hudea_lucian_722.Status;

public class Register {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("district")
    private int district;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("skillLevel")
    private int skillLevel;

    public Register(int id, String name, int district, Status status, int skillLevel) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.status = status;
        this.skillLevel = skillLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDistrict() {
        return district;
    }

    public Status getStatus() {
        return status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }
}
