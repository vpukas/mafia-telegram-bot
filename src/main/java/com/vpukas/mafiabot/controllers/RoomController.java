package com.vpukas.mafiabot.controllers;

import com.vpukas.mafiabot.entities.Player;
import com.vpukas.mafiabot.entities.Room;
import com.vpukas.mafiabot.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    private RoomService roomService;

    @Autowired
    public void setRoomService(RoomService roomService){
        this.roomService = roomService;
    }

    public void addPlayerToRoom(Long roomId, Player player){
        roomService.addPlayerToRoom(roomId, player);
    }

    public void startNewGame(Room room){
        roomService.startNewGame(room);
    }
}
