package com.chat_app.com.chat_app.repositories;

import com.chat_app.com.chat_app.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoomRepository extends MongoRepository<Room, String> {

    public Room findByRoomId(String roomId);
}
