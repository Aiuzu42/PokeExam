package me.aiuzu.pokeexam.webservice.rest.models;

import java.util.List;

public class Encounter {

    private Location location_area;
    private List<VersionDetail> version_details;

    public Location getLocation_area() {
        return location_area;
    }

    public void setLocation_area(Location location_area) {
        this.location_area = location_area;
    }

    public List<VersionDetail> getVersion_details() {
        return version_details;
    }

    public void setVersion_details(List<VersionDetail> version_details) {
        this.version_details = version_details;
    }

}
