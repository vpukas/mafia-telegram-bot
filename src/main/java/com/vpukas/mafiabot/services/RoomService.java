package com.vpukas.mafiabot.services;

import com.vpukas.mafiabot.entities.Player;
import com.vpukas.mafiabot.entities.Room;
import com.vpukas.mafiabot.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public void startNewGame(Room room){
        roomRepository.save(room);
    }

    @Transactional
    public void addPlayerToRoom(Long roomId, Player player){
        roomRepository.findFirstByGameChatId(roomId).get().getPlayers().add(player);
    }

    public Room getRoomById(Long roomId){
        return roomRepository.findFirstByGameChatId(roomId).get();
    }
}
