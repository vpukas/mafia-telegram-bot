package com.vpukas.mafiabot.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;
    private Long gameChatId;
    private Integer playersAmount = 0;
    private Boolean isOver = false;
    private Boolean isNight = false;
    @OneToMany(mappedBy = "room")
    private Set<Player> players = new HashSet<>();
    public Room(Long gameChatId){
        this.gameChatId = gameChatId;
    }
}
