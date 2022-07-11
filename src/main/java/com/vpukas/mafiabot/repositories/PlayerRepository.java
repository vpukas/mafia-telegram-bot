package com.vpukas.mafiabot.repositories;

import com.vpukas.mafiabot.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findPlayerByUserTelegramId(Long userTelegramId);
}
