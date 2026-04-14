package com.example.energia.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "promozioni")
public class Promozione {
    private String id;
    private String fornitore;
    private int tariffe;
    private LocalDate dataScadenza;
}
