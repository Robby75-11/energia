package com.example.energia.service;

import com.example.energia.entity.Promozione;
import com.example.energia.repository.PromozioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromozioneService {

    @Autowired
    private PromozioneRepository repository;

    // CREATE
    public Promozione salvaPromozione(Promozione promozione) {
        return repository.save(promozione);
    }

    // READ ALL
    public List<Promozione> getAllPromozioni() {
        return repository.findAll();
    }

    // READ BY ID
    public Optional<Promozione> getPromozioneById(String id) {
        return repository.findById(id);
    }

    // UPDATE
    public Promozione aggiornaPromozione(String id, Promozione nuovaPromozione) {
        return repository.findById(id).map(p -> {
            p.setFornitore(nuovaPromozione.getFornitore());
            p.setTariffe(nuovaPromozione.getTariffe());
            p.setDataScadenza(nuovaPromozione.getDataScadenza());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Promozione non trovata"));
    }

    // DELETE
    public void eliminaPromozione(String id) {
        repository.deleteById(id);
    }
}