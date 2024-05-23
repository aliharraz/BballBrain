package com.ghacham.basketball.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ghacham.basketball.clients.UtilisateurClient;
import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.entities.Team;
import com.ghacham.basketball.exception.UnauthorizedException;
import com.ghacham.basketball.services.TeamService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;
    
    @Autowired
    private UtilisateurClient utilisateurClient;

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
    public Team createTeam(@RequestBody Team team, @RequestHeader("Authorization") String token) {
        String role = utilisateurClient.getUserRole(token);
        if (!"COACH".equals(role)) {
            throw new UnauthorizedException("Only coaches can create teams");
        }
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
    @PostMapping("/{id}/players")
    public Team addPlayersToTeam(@PathVariable Long id, @RequestBody Set<Long> playerIds, @RequestHeader("Authorization") String token) {
        String role = utilisateurClient.getUserRole(token);
        if (!"COACH".equals(role)) {
            throw new UnauthorizedException("Only coaches can add players to teams");
        }
        Team team = teamService.getTeamById(id);
        for (Long playerId : playerIds) {
            Player player = utilisateurClient.getPlayerById(playerId);
            team.getPlayers().add(player);
        }
        return teamService.updateTeam(id, team);
    }
}
