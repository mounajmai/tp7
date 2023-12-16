package com.tp7.service;


import com.tp7.Repository.RentalContractRepository;
import com.tp7.entity.RentalContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalContractService {

    @Autowired
    private RentalContractRepository rentalContractRepository;

    public List<RentalContract> getAllRentalContracts() {
        return rentalContractRepository.findAll();
    }

    public RentalContract getRentalContractById(long id) {
        return rentalContractRepository.findById(id).orElse(null);
    }

    public RentalContract createRentalContract(RentalContract rentalContract) {
        // Vous pouvez ajouter une logique de validation ici si nécessaire
        return rentalContractRepository.save(rentalContract);
    }

    public RentalContract updateRentalContract(long id, RentalContract updatedRentalContract) {
        RentalContract existingRentalContract = rentalContractRepository.findById(id).orElse(null);

        if (existingRentalContract != null) {
            // Mettez à jour les champs de l'entité existante avec les valeurs fournies
            existingRentalContract.setProperty(updatedRentalContract.getProperty());
            existingRentalContract.setOwner(updatedRentalContract.getOwner());
            existingRentalContract.setTenant(updatedRentalContract.getTenant());
            existingRentalContract.setMonthlyRent(updatedRentalContract.getMonthlyRent());

            // Enregistrez les modifications dans la base de données
            return rentalContractRepository.save(existingRentalContract);
        } else {
            return null;
        }
    }

    public boolean deleteRentalContract(long id) {
        RentalContract existingRentalContract = rentalContractRepository.findById(id).orElse(null);

        if (existingRentalContract != null) {
            // Supprimez l'entité de la base de données
            rentalContractRepository.delete(existingRentalContract);
            return true;
        } else {
            return false;
        }
    }
}

