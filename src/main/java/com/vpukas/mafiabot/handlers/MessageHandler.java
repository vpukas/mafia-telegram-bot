package com.vpukas.mafiabot.handlers;

import com.vpukas.mafiabot.controllers.PlayerController;
import com.vpukas.mafiabot.controllers.RoomController;
import com.vpukas.mafiabot.entities.Player;
import com.vpukas.mafiabot.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageHandler {

    private PlayerController playerController;
    private RoomController roomController;


    @Autowired
    public void setPlayerController(PlayerController playerController){
        this.playerController = playerController;
    }
    @Autowired
    public void setRoomController(RoomController roomController){
        this.roomController = roomController;
    }
    public void handleIncomingMessage(Message message){
        if(message.hasText()) {
            if (message.getChat().isUserChat()) {
                handlePrivateIncomingMessage(message);
            }
            handleGroupChatIncomingMessage(message);
        }
    }

    private void handlePrivateIncomingMessage(Message message){
        Long userId = message.getFrom().getId();
        String userName = message.getFrom().getUserName();
        Long chatId = Long.parseLong(message.getChatId().toString());
        if(message.getText().equals("/start@tg_mafia_bot")){
            Player testPlayer = new Player(userId, userName);
            Room testRoom = new Room(userId);
//            playerController.registerNewPlayer(testPlayer);
//            roomController.startNewGame(testRoom);
//            roomController.addPlayerToRoom(userId,testPlayer );
//            playerController.setPlayerRoom(userId, testRoom);


        }
    }

    private void handleGroupChatIncomingMessage(Message message){

    }
}
