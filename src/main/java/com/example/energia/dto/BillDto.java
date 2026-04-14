package com.example.energia.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class BillDto {
    private String id;
    private String userId;
    private double importo;
    private LocalDate dataEmissione;
    private LocalDate dataScadenza;
    private String StatoPagamento; // "PAGATA", "IN_SCADENZA", "SCADUTA"
    private String tipoUtenza; // "LUCE, "GAS", "ACQUA"
    private int meseRiferimento; // 1-12
    private int annoRiferimento; // 2026
}
