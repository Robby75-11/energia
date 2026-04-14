package com.example.energia.service;

import com.example.energia.dto.BillDto;
import com.example.energia.entity.Bill;
import com.example.energia.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    // Crea una bolletta
    public BillDto createBill(BillDto dto) {
        Bill bill = mapToEntity(dto);
        Bill saved = billRepository.save(bill);
        return mapToDto(saved);
    }

    // Lista bollette
    public List<BillDto> getAllBills() {
        return billRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Bollette per utente
    public List<BillDto> getBillsByUser(String userId) {
        return billRepository.findByUserId(userId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Aggiorna bolletta
    public BillDto updateBill(String id, BillDto dto) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        bill.setImporto(dto.getImporto());
        bill.setDataEmissione(dto.getDataEmissione());
        bill.setDataScadenza(dto.getDataScadenza());
        bill.setStatoPagamento(dto.getStatoPagamento());
        bill.setTipoUtenza(dto.getTipoUtenza());
        bill.setMeseRiferimento(dto.getMeseRiferimento());
        bill.setAnnoRiferimento(dto.getAnnoRiferimento());
        Bill updated = billRepository.save(bill);
        return mapToDto(updated);
    }

    // Elimina bolletta
    public void deleteBill(String id) {
        billRepository.deleteById(id);
    }

    // Mapping DTO <-> Entity
    private BillDto mapToDto(Bill bill) {
        BillDto dto = new BillDto();
        dto.setId(bill.getId());
        dto.setUserId(bill.getUserId());
        dto.setImporto(bill.getImporto());
        dto.setDataEmissione(bill.getDataEmissione());
        dto.setDataScadenza(bill.getDataScadenza());
        dto.setStatoPagamento(bill.getStatoPagamento());
        dto.setTipoUtenza(bill.getTipoUtenza());
        dto.setMeseRiferimento(bill.getMeseRiferimento());
        dto.setAnnoRiferimento(bill.getAnnoRiferimento());
        return dto;
    }

    private Bill mapToEntity(BillDto dto) {
        Bill bill = new Bill();
        bill.setUserId(dto.getUserId());
        bill.setImporto(dto.getImporto());
        bill.setDataEmissione(dto.getDataEmissione());
        bill.setDataScadenza(dto.getDataScadenza());
        bill.setStatoPagamento(dto.getStatoPagamento());
        bill.setTipoUtenza(dto.getTipoUtenza());
        bill.setMeseRiferimento(dto.getMeseRiferimento());
        bill.setAnnoRiferimento(dto.getAnnoRiferimento());
        return bill;
    }
}