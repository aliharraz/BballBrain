package com.ghacham.basketball.entities;

import java.util.List;
import jakarta.persistence.Column;

import jakarta.persistence.*;

@Entity
@Table(name = "Coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coachId;

    @Column(name = "coach_name") // Mapping to the column "coach_name" in the database
    private String coachName;
    
    @Column(name = "coach_age") // Mapping to the column "coach_name" in the database
    private int coachAge;
    
    @OneToMany(mappedBy = "invitedByCoach")
    private List<Player> invitedPlayers;

    public int getCoachAge() {
		return coachAge;
	}

	public void setCoachAge(int coachAge) {
		this.coachAge = coachAge;
	}

	@ManyToOne
    private Team team;

    // Getters and setters
    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    public List<Player> getInvitedPlayers() {
        return invitedPlayers;
    }

    public void setInvitedPlayers(List<Player> invitedPlayers) {
        this.invitedPlayers = invitedPlayers;
    }
}
