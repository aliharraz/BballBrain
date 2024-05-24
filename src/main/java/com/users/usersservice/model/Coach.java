package com.users.usersservice.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach extends Utilisateur {
    private Long teamId;
    private int experienceYears;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach coach)) return false;
        if (!super.equals(o)) return false;
        return getExperienceYears() == coach.getExperienceYears() && Objects.equals(getTeamId(), coach.getTeamId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTeamId(), getExperienceYears());
    }
}

