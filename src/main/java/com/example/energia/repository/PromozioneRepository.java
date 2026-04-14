package com.example.energia.repository;

import com.example.energia.entity.Promozione;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PromozioneRepository extends MongoRepository<Promozione, String> {

}
