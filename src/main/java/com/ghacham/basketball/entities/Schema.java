package com.ghacham.basketball.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Schema")

public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;

    private String title;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "team_id") // Assuming the column name in Schema table referencing Team is team_id
    private Team team;

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
