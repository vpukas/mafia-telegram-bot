package com.vpukas.mafiabot.messagesender;

import com.vpukas.mafiabot.MafiaBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {

    private MafiaBot bot;

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try{
            bot.execute(sendMessage);

        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Autowired
    public void setMafiaBot(MafiaBot bot){
        this.bot = bot;
    }
}
