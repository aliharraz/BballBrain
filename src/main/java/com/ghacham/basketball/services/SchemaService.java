package com.ghacham.basketball.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.repository.SchemaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SchemaService {

    @Autowired
    private SchemaRepository schemaRepository;

    public List<Schema> getAllSchemas() {
        return schemaRepository.findAll();
    }

    public Schema getSchemaById(Long id) {
        Optional<Schema> optionalSchema = schemaRepository.findById(id);
        return optionalSchema.orElse(null); // Return null if schema not found, can also throw an exception
    }

    public Schema createSchema(Schema schema) {
        return schemaRepository.save(schema);
    }

    public Schema updateSchema(Long id, Schema updatedSchema) {
        Optional<Schema> optionalSchema = schemaRepository.findById(id);
        if (optionalSchema.isPresent()) {
            Schema existingSchema = optionalSchema.get();
            existingSchema.setTitle(updatedSchema.getTitle());
            existingSchema.setDescription(updatedSchema.getDescription());
            existingSchema.setVisibility(updatedSchema.getVisibility());
            existingSchema.setTeam(updatedSchema.getTeam());
            return schemaRepository.save(existingSchema);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteSchema(Long id) {
        schemaRepository.deleteById(id);
    }
    
    public void addPlayerToSchema(Long schemaId, Player player) {
        Optional<Schema> optionalSchema = schemaRepository.findById(schemaId);
        if (optionalSchema.isPresent()) {
            Schema schema = optionalSchema.get();
            schema.getPlayers().add(player);
            schemaRepository.save(schema);
        } else {
            throw new RuntimeException("Schema not found");
        }
    }

    public void removePlayerFromSchema(Long schemaId, Player player) {
        Optional<Schema> optionalSchema = schemaRepository.findById(schemaId);
        if (optionalSchema.isPresent()) {
            Schema schema = optionalSchema.get();
            schema.getPlayers().remove(player);
            schemaRepository.save(schema);
        } else {
            throw new RuntimeException("Schema not found");
        }
    }

    // Autres méthodes pour la gestion des schémas
}
