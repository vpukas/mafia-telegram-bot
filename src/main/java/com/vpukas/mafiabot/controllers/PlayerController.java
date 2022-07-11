package com.vpukas.mafiabot.controllers;

import com.vpukas.mafiabot.entities.Player;
import com.vpukas.mafiabot.entities.Room;
import com.vpukas.mafiabot.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public void setPlayerService(PlayerService playerService){
        this.playerService = playerService;
    }
    public void registerNewPlayer(Player player){
        playerService.registerNewPlayer(player);
    }
    public void setPlayerRoom(Long playerTelegramId, Room room){
        playerService.setPlayerRoom(playerTelegramId, room);
    }
}
