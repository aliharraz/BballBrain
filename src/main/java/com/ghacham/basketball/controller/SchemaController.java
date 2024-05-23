package com.ghacham.basketball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.services.SchemaService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/schemas")
public class SchemaController {

    @Autowired
    private SchemaService schemaService;
    
 

    @GetMapping
    public List<Schema> getAllSchemas() {
        return schemaService.getAllSchemas();
    }

    @GetMapping("/{id}")
    public Schema getSchemaById(@PathVariable Long id) {
        return schemaService.getSchemaById(id);
    }

    @PostMapping
    public Schema createSchema(@RequestBody Schema schema) {
        return schemaService.createSchema(schema);
    }

    @PutMapping("/{id}")
    public Schema updateSchema(@PathVariable Long id, @RequestBody Schema updatedSchema) {
        return schemaService.updateSchema(id, updatedSchema);
    }

    @DeleteMapping("/{id}")
    public void deleteSchema(@PathVariable Long id) {
        schemaService.deleteSchema(id);
    }
    
    /*@PostMapping("/{id}/players")
    public void addPlayersToSchema(@PathVariable Long id, @RequestBody Set<Long> playerIds) {
        playerIds.forEach(playerId -> {
            Player player = utilisateurClient.getPlayerById(playerId);
            schemaService.addPlayerToSchema(id, player);
        });
    }

    @DeleteMapping("/{id}/players")
    public void removePlayersFromSchema(@PathVariable Long id, @RequestBody Set<Long> playerIds) {
        playerIds.forEach(playerId -> {
            Player player = utilisateurClient.getPlayerById(playerId);
            schemaService.removePlayerFromSchema(id, player);
        });
    }*/

    // Autres méthodes pour la gestion des schémas
}
