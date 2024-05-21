package com.ghacham.basketball.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ghacham.basketball.entities.Team;
import com.ghacham.basketball.services.TeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // Endpoint pour récupérer tous les teams
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // Endpoint pour récupérer un team par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long teamId) {
        Team team = teamService.getTeamById(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(team);
    }

    // Endpoint pour créer un nouveau team
    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    // Endpoint pour mettre à jour un team existant
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") Long teamId, @RequestBody Team teamDetails) {
        Team updatedTeam = teamService.updateTeam(teamId, teamDetails);
        if (updatedTeam == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedTeam);
    }

    // Endpoint pour supprimer un team
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable(value = "id") Long teamId) {
        if (!teamService.existsById(teamId)) {
            return ResponseEntity.notFound().build();
        }
        teamService.deleteTeam(teamId);
        return ResponseEntity.ok().build();
    }
}
