package me.aiuzu.pokeexam.webservice.rest;

import me.aiuzu.pokeexam.webservice.rest.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokeRepository {

    @Autowired
    PokeRest pr;

    public int getBaseExperience(String name) {
        Pokemon pk = pr.getPokemonInfo(name);
        return pk.getBase_experience();
    }

    public aiuzu.me.GetAbilitiesResponse getAbilities(String name) {
        Pokemon pk = pr.getPokemonInfo(name);
        aiuzu.me.GetAbilitiesResponse response = new aiuzu.me.GetAbilitiesResponse();
        for (AbilityInfo ai : pk.getAbilities()) {
            aiuzu.me.AbilityInfo aInfo = new aiuzu.me.AbilityInfo();
            aInfo.setSlot(ai.getSlot());
            aInfo.setIsHidden(ai.isIs_hidden());
            aiuzu.me.Ability a = new aiuzu.me.Ability();
            a.setUrl(ai.getAbility().getUrl());
            a.setName(ai.getAbility().getName());
            aInfo.setAbility(a);
            response.getAbilities().add(aInfo);
        }
        return response;
    }

    public aiuzu.me.GetHeldItemsResponse getHeldItems(String name) {
        Pokemon pk = pr.getPokemonInfo(name);
        aiuzu.me.GetHeldItemsResponse response = new aiuzu.me.GetHeldItemsResponse();
        for (HeldItem hi : pk.getHeld_items()) {
            aiuzu.me.HeldItem h = new aiuzu.me.HeldItem();
            aiuzu.me.Item item = new aiuzu.me.Item();
            item.setName(hi.getItem().getName());
            item.setUrl(hi.getItem().getUrl());
            h.setItem(item);
            for (VersionDetail vd : hi.getVersion_details()) {
                aiuzu.me.VersionDetail v = new aiuzu.me.VersionDetail();
                v.setRarity(vd.getRarity());
                aiuzu.me.Version version = new aiuzu.me.Version();
                version.setName(vd.getVersion().getName());
                version.setUrl(vd.getVersion().getUrl());
                v.setVersion(version);
                h.getVersionDetails().add(v);
            }
            response.getHeldItems().add(h);
        }
        return response;
    }

    public aiuzu.me.GetIdResponse getId(String name) {
        Pokemon pk = pr.getPokemonInfo(name);
        aiuzu.me.GetIdResponse response = new aiuzu.me.GetIdResponse();
        response.setId(pk.getId());
        return response;
    }

    public aiuzu.me.GetNameResponse getName(String name) {
        Pokemon pk = pr.getPokemonInfo(name);
        aiuzu.me.GetNameResponse response = new aiuzu.me.GetNameResponse();
        response.setName(pk.getName());
        return response;
    }

    public aiuzu.me.GetLocationAreaEncountersResponse getLocationAreaEncounters(String name) {
        Pokemon pk = pr.getPokemonInfo(name);
        Encounter[] encounterList = pr.getEncounters(pk.getLocation_area_encounters());
        aiuzu.me.GetLocationAreaEncountersResponse response = new aiuzu.me.GetLocationAreaEncountersResponse();
        for (Encounter en : encounterList) {
            aiuzu.me.Encounter e = new aiuzu.me.Encounter();
            aiuzu.me.Location l = new aiuzu.me.Location();
            l.setName(en.getLocation_area().getName());
            l.setUrl(en.getLocation_area().getUrl());
            e.setLocation(l);
            for (VersionDetail vd : en.getVersion_details()) {
                aiuzu.me.VersionDetailsEncounter v = new aiuzu.me.VersionDetailsEncounter();
                v.setMaxChance(vd.getMax_chance());
                aiuzu.me.Version version = new aiuzu.me.Version();
                version.setUrl(vd.getVersion().getUrl());
                version.setName(vd.getVersion().getName());
                v.setVersion(version);
                e.getVersionDetails().add(v);
            }
            response.getEncounter().add(e);
        }
        return response;
    }

}
