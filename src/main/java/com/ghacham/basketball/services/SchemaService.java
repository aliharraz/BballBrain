package com.ghacham.basketball.services;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.repository.SchemaRepository;

import java.util.List;

@Service
public class SchemaService {

    @Autowired
    private SchemaRepository schemaRepository;

    public List<Schema> getAllSchemas() {
        return schemaRepository.findAll();
    }

    public Schema createSchema(Schema schema) {
        return schemaRepository.save(schema);
    }

    // Autres méthodes pour la mise à jour, la suppression, etc.
}
