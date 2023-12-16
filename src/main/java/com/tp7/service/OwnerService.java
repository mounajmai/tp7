package com.tp7.service;


import com.tp7.Repository.OwnerRepository;
import com.tp7.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner createOwner(Owner owner) {
        // Vous pouvez ajouter une logique de validation ici si nécessaire
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(long id, Owner updatedOwner) {
        Owner existingOwner = ownerRepository.findById(id).orElse(null);

        if (existingOwner != null) {
            // Mettez à jour les champs de l'entité existante avec les valeurs fournies
            existingOwner.setName(updatedOwner.getName());
            existingOwner.setContactInformation(updatedOwner.getContactInformation());

            // Enregistrez les modifications dans la base de données
            return ownerRepository.save(existingOwner);
        } else {
            return null;
        }
    }

    public boolean deleteOwner(long id) {
        Owner existingOwner = ownerRepository.findById(id).orElse(null);

        if (existingOwner != null) {
            // Supprimez l'entité de la base de données
            ownerRepository.delete(existingOwner);
            return true;
        } else {
            return false;
        }
    }
}
