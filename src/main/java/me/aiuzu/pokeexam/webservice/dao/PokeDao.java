package me.aiuzu.pokeexam.webservice.dao;

import me.aiuzu.pokeexam.webservice.dao.models.Registry;
import org.springframework.data.repository.CrudRepository;

public interface PokeDao extends CrudRepository<Registry, Integer> {}
