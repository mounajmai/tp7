package com.tp7.service;

import com.tp7.Repository.PropertyRepository;
import com.tp7.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public Property createProperty(Property property) {
        // Vous pouvez ajouter une logique de validation ici si nécessaire
        return propertyRepository.save(property);
    }

    public Property updateProperty(long id, Property updatedProperty) {
        Property existingProperty = propertyRepository.findById(id).orElse(null);

        if (existingProperty != null) {
            // Mettez à jour les champs de l'entité existante avec les valeurs fournies
            existingProperty.setAddress(updatedProperty.getAddress());
            existingProperty.setPrice(updatedProperty.getPrice());

            // Enregistrez les modifications dans la base de données
            return propertyRepository.save(existingProperty);
        } else {
            return null;
        }
    }

    public boolean deleteProperty(long id) {
        Property existingProperty = propertyRepository.findById(id).orElse(null);

        if (existingProperty != null) {
            // Supprimez l'entité de la base de données
            propertyRepository.delete(existingProperty);
            return true;
        } else {
            return false;
        }
    }
}
