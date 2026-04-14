package com.example.energia.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Document (collection = "bills")

public class Bill {
    @Id
    private String id;
    private String userId;
    private double importo;
    private LocalDate dataEmissione;
    private LocalDate dataScadenza;
    private String StatoPagamento; // "PAGATA", "IN_SCADENZA", "SCADUTA"
    private String tipoUtenza; //"LUCE, "GAS", "LUCE_E_GAS"
    private int meseRiferimento; // 1-12
    private int annoRiferimento; // 2026


}
