package com.mexpedition.web.controller;

import com.mexpedition.dao.ExpeditionDao;
import com.mexpedition.model.Expedition;
import com.mexpedition.web.exception.ExpeditionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    Logger log = LoggerFactory.getLogger(this.getClass());

    // creer une expedition
    @PostMapping(value = "/Expedition")
    public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition expedition){

        Expedition expeditionAdded = expeditionDao.save(expedition);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(expeditionAdded.getId()).toUri();

        ResponseEntity<Expedition> expeditionAjout = ResponseEntity.created(location).build();
        return expeditionAjout;
    }


    //Récuperer une Expedition par son id
    @GetMapping(value = "/Expedition/{id}")
    public Expedition recupererUneExpedition(@PathVariable int id){

        Optional<Expedition> expedition = expeditionDao.findById(id);

        if(!expedition.isPresent()) throw new ExpeditionNotFoundException("Cette expedition n'existe pas");

        else return expedition.get();
    }

    //Récuperer une Expedition par son id
    @GetMapping(value = "/suivi/{idCommande}")
    public Optional<Expedition> etatExpedition(@PathVariable int idCommande){

        Optional<Expedition> expedition = expeditionDao.findByIdCommandeLike(idCommande);

        if(!expedition.isPresent()) throw new ExpeditionNotFoundException("Cette expedition n'existe pas");

        else return expedition;

    }


    //Mettre a une jour expedition
    @PutMapping(value = "/Expedition")
    public void updateExpedition(@RequestBody Expedition expedition) {

        expeditionDao.save(expedition);
    }

}

