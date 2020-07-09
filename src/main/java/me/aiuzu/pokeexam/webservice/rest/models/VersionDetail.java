package me.aiuzu.pokeexam.webservice.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VersionDetail {

    private int rarity;
    private Version version;
    private List<EncounterDetail> encounter_details;
    private int max_chance;

    public List<EncounterDetail> getEncounter_details() {
        return encounter_details;
    }

    public void setEncounter_details(List<EncounterDetail> encounter_details) {
        this.encounter_details = encounter_details;
    }

    public int getMax_chance() {
        return max_chance;
    }

    public void setMax_chance(int max_chance) {
        this.max_chance = max_chance;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

}
