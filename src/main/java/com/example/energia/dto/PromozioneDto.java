package com.example.energia.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PromozioneDto {
    private String id;
    private String fornitore;
    private int tariffe;
    private LocalDate dataScadenza;
}
