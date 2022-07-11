package com.vpukas.mafiabot.repositories;

import com.vpukas.mafiabot.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findFirstByGameChatId(Long gameChatId);
}
