package me.aiuzu.pokeexam.webservice.rest.models;

public class EncounterDetail {

    private int chance;
    private int max_level;
    private Method method;
    private int min_level;

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getMax_level() {
        return max_level;
    }

    public void setMax_level(int max_level) {
        this.max_level = max_level;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public int getMin_level() {
        return min_level;
    }

    public void setMin_level(int min_level) {
        this.min_level = min_level;
    }

}
