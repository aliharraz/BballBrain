package com.ghacham.basketball.clients;

import com.ghacham.basketball.entities.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "utilisateur-service", url = "http://localhost:8081")
public interface UtilisateurClient {

    @GetMapping("/players/{id}")
    Player getPlayerById(@PathVariable("id") Long id);
    
    @GetMapping("/utilisateur/role")
    String getUserRole(@RequestHeader("Authorization") String token);
}
