package me.aiuzu.pokeexam.webservice;

import aiuzu.me.*;
import me.aiuzu.pokeexam.webservice.dao.PokeDao;
import me.aiuzu.pokeexam.webservice.dao.models.Registry;
import me.aiuzu.pokeexam.webservice.rest.PokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Endpoint
public class PokeEndpoint {

    private static final String NAMESPACE = "me.aiuzu";

    private PokeRepository pokeRepository;

    @Autowired
    private HttpServletRequest context;

    @Autowired
    private PokeDao pokeDao;

    @Autowired
    public PokeEndpoint(PokeRepository pokeRepository) {
        this.pokeRepository = pokeRepository;
    }

    @PayloadRoot(localPart = "getBaseExperienceRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetBaseExperienceResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {
        pokeDao.save(getRegistryEntry("base_experience"));
        GetBaseExperienceResponse response = new GetBaseExperienceResponse();
        response.setBaseExperience(pokeRepository.getBaseExperience(request.getName()));
        return response;
    }



    @PayloadRoot(localPart = "getAbilitiesRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetAbilitiesResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {
        pokeDao.save(getRegistryEntry("abilities"));
        GetAbilitiesResponse response = pokeRepository.getAbilities(request.getName());
        return response;
    }

    @PayloadRoot(localPart = "getHeldItemsRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetHeldItemsResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {
        pokeDao.save(getRegistryEntry("held_items"));
        GetHeldItemsResponse response = pokeRepository.getHeldItems(request.getName());
        return response;
    }

    @PayloadRoot(localPart = "getIdRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetIdResponse getId(@RequestPayload GetIdRequest request) {
        pokeDao.save(getRegistryEntry("id"));
        GetIdResponse response = pokeRepository.getId(request.getName());
        return response;
    }

    @PayloadRoot(localPart = "getNameRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetNameResponse getName(@RequestPayload GetNameRequest request) {
        pokeDao.save(getRegistryEntry("name"));
        GetNameResponse response = pokeRepository.getName(request.getName());
        return response;
    }

    @PayloadRoot(localPart = "getLocationAreaEncountersRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
        pokeDao.save(getRegistryEntry("location_area_encounters"));
        GetLocationAreaEncountersResponse response = pokeRepository.getLocationAreaEncounters(request.getName());
        return response;
    }

    private String getIpAddress() {
        String ip = context.getHeader("X-FORWARDED_FOR");
        if (ip == null) {
            ip = context.getRemoteAddr();
        }
        return ip;
    }

    private String getDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date();
        return formatter.format(date);
    }

    private Registry getRegistryEntry(String endpoint) {
        Registry r = new Registry();
        r.setDate(getDate());
        r.setEndpoint(endpoint);
        r.setIp(getIpAddress());
        return r;
    }

}
