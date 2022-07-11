package com.vpukas.mafiabot.services;

import com.vpukas.mafiabot.entities.Player;
import com.vpukas.mafiabot.entities.Room;
import com.vpukas.mafiabot.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public void setPlayerRepository(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void registerNewPlayer(Player player){
        Optional<Player> playerOptional = playerRepository.findPlayerByUserTelegramId(player.getUserTelegramId());
        if (playerOptional.isPresent()) {
            throw new IllegalStateException("already exists");
        }
        playerRepository.save(player);
    }
    @Transactional
    public void setPlayerRoom(Long playerTelegramId, Room room){
        playerRepository.findPlayerByUserTelegramId(playerTelegramId).get().setRoom(room);
    }


}
