package me.aiuzu.pokeexam.webservice.rest;

import me.aiuzu.pokeexam.webservice.rest.models.Encounter;
import me.aiuzu.pokeexam.webservice.rest.models.Pokemon;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokeRest {

    private static final String URI_POKEMON = "https://pokeapi.co/api/v2/pokemon/";
    private static final String USER_AGENT = "AnyUserAgent";

    public Pokemon getPokemonInfo(String name) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, USER_AGENT);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<Pokemon> pk = rt.exchange(URI_POKEMON + name, HttpMethod.GET, entity, Pokemon.class);
        return pk.getBody();
    }

    public Encounter[] getEncounters(String url) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, USER_AGENT);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<Encounter[]> pk = rt.exchange(url, HttpMethod.GET, entity, Encounter[].class);
        return pk.getBody();
    }

}
