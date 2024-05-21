package com.ghacham.basketball.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.services.SchemaService;

import java.util.List;

@RestController
@RequestMapping("/schemas")
public class SchemaController {

    @Autowired
    private SchemaService schemaService;

    @GetMapping
    public List<Schema> getAllSchemas() {
        return schemaService.getAllSchemas();
    }

    @PostMapping
    public Schema createSchema(@RequestBody Schema schema) {
        return schemaService.createSchema(schema);
    }

    // Autres méthodes pour la mise à jour, la suppression, etc.
}
