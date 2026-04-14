package com.example.energia.controller;

import com.example.energia.dto.BillDto;
import com.example.energia.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor

public class BillController {
    private final BillService billService;

    // Crea una nuova bolletta
    @PostMapping
    public ResponseEntity<BillDto> createBill(@RequestBody BillDto dto) {
        BillDto created = billService.createBill(dto);
        return ResponseEntity.ok(created);
    }

    // Recupera tutte le bollette
    @GetMapping
    public ResponseEntity<List<BillDto>> getAllBills() {
        List<BillDto> bills = billService.getAllBills();
        return ResponseEntity.ok(bills);
    }

    // Recupera bollette di un utente specifico
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BillDto>> getBillsByUser(@PathVariable String userId) {
        List<BillDto> bills = billService.getBillsByUser(userId);
        return ResponseEntity.ok(bills);
    }

    // Aggiorna una bolletta
    @PutMapping("/{id}")
    public ResponseEntity<BillDto> updateBill(@PathVariable String id, @RequestBody BillDto dto) {
        BillDto updated = billService.updateBill(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Elimina una bolletta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable String id) {
        billService.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
