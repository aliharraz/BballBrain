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
public class Player extends Utilisateur {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        if (!super.equals(o)) return false;
        return getJerseyNumber() == player.getJerseyNumber() && Objects.equals(getPosition(), player.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPosition(), getJerseyNumber());
    }

    private String position;
    private int jerseyNumber;

    // getters et setters
}
