package com.example.energia.controller;

import com.example.energia.entity.Promozione;
import com.example.energia.service.PromozioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promozioni")
@CrossOrigin
public class PromozioneController {

    @Autowired
    private PromozioneService service;

    // CREATE
    @PostMapping
    public Promozione creaPromozione(@RequestBody Promozione promozione) {
        return service.salvaPromozione(promozione);
    }

    // READ ALL
    @GetMapping
    public List<Promozione> getAllPromozioni() {
        return service.getAllPromozioni();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Promozione getPromozioneById(@PathVariable String id) {
        return service.getPromozioneById(id)
                .orElseThrow(() -> new RuntimeException("Promozione non trovata"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Promozione aggiornaPromozione(@PathVariable String id,
                                         @RequestBody Promozione promozione) {
        return service.aggiornaPromozione(id, promozione);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminaPromozione(@PathVariable String id) {
        service.eliminaPromozione(id);
    }
}