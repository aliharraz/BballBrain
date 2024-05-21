package com.ghacham.basketball.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column(name = "player_name") // Mapping to the column "player_name" in the database
    private String playerName;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // Getters and setters
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}