package com.vpukas.mafiabot;

import com.vpukas.mafiabot.handlers.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class MafiaBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    private String botUserName;
    @Value("${telegram.bot.token}")
    private String botToken;
    private MessageHandler commandHandler;
    @Autowired
    public void setCommandHandler(MessageHandler commandHandler){
        this.commandHandler = commandHandler;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            commandHandler.handleIncomingMessage(update.getMessage());
        }
    }
}
