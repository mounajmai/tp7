package com.tp7.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.tp7.entity.Owner;
import com.tp7.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Controller
@RequestMapping("/api/owners")
public class OwnerController {



    @GetMapping("/{id}/details")
    public String showOwnerDetails(@PathVariable long id, Model model) {
        Owner owner = ownerService.getOwnerById(id);
        if (owner != null) {
            model.addAttribute("owner", owner);
            return "owner"; // Assurez-vous que "owner" est le nom du template Thymeleaf
        } else {
            return "owner-not-found";
        }
    }


    @Autowired
    private OwnerService ownerService;

    // RESTful API methods
    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerService.getAllOwners();
        return ResponseEntity.ok().body(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable long id) {
        Owner owner = ownerService.getOwnerById(id);
        if (owner != null) {
            return ResponseEntity.ok().body(owner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        Owner createdOwner = ownerService.createOwner(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOwner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable long id, @RequestBody Owner owner) {
        Owner updatedOwner = ownerService.updateOwner(id, owner);
        if (updatedOwner != null) {
            return ResponseEntity.ok().body(updatedOwner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable long id) {
        boolean deleted = ownerService.deleteOwner(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
