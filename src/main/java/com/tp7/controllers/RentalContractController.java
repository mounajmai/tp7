package com.tp7.controllers;

import com.tp7.entity.RentalContract;
import com.tp7.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rental-contracts")
public class RentalContractController {

    @Autowired
    private RentalContractService rentalContractService;

    @GetMapping
    public List<RentalContract> getAllRentalContracts() {
        return rentalContractService.getAllRentalContracts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalContract> getRentalContractById(@PathVariable long id) {
        RentalContract rentalContract = rentalContractService.getRentalContractById(id);
        return rentalContract != null ? ResponseEntity.ok(rentalContract) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RentalContract> createRentalContract(@RequestBody RentalContract rentalContract) {
        RentalContract createdRentalContract = rentalContractService.createRentalContract(rentalContract);
        return ResponseEntity.ok(createdRentalContract);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalContract> updateRentalContract(@PathVariable long id, @RequestBody RentalContract updatedRentalContract) {
        RentalContract rentalContract = rentalContractService.updateRentalContract(id, updatedRentalContract);
        return rentalContract != null ? ResponseEntity.ok(rentalContract) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalContract(@PathVariable long id) {
        return rentalContractService.deleteRentalContract(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

