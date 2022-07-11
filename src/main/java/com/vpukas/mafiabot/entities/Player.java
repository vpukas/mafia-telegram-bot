package com.vpukas.mafiabot.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private Long userTelegramId;
    private String playerName;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room;
    private Boolean isAlive = false;
    private Boolean isPlaying = false;
    private Boolean isGameOwner = false;
    //private Long privateChatId;
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    public Player(Long userTelegramId,
                  String playerName){
        this.userTelegramId = userTelegramId;
        this.playerName = playerName;
    }
}
