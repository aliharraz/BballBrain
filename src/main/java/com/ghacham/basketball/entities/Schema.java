package com.ghacham.basketball.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "schema")
@JsonIgnoreProperties({"team"}) 
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;

    private String title;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "team_id") // Assuming the column name in Schema table referencing Team is team_id
    private Team team;

    @ManyToMany
    @JoinTable(
        name = "schema_player",
        joinColumns = @JoinColumn(name = "schema_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> players;
    
    public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Long getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(Long schemaId) {
		this.schemaId = schemaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	@Enumerated(EnumType.STRING)
    private Visibility visibility;

    // Getters and setters
}
