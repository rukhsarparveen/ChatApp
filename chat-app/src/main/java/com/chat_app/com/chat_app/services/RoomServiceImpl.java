package com.chat_app.com.chat_app.services;

import com.chat_app.com.chat_app.entities.Message;
import com.chat_app.com.chat_app.entities.Room;
import com.chat_app.com.chat_app.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(String roomId) {
        if(roomRepository.findByRoomId(roomId) == null){
            Room room = new Room();
            room.setRoomId(roomId);
            Room savedRoom = roomRepository.save(room);
            return savedRoom;
        }
        return null;
    }

    @Override
    public Room joinRoom(String roomId) {
        if(roomRepository.findByRoomId(roomId)==null){
            return null;
        }
        return roomRepository.findByRoomId(roomId);
    }

    @Override
    public List<Message> getMessages(String roomId) {
        if (roomRepository.findByRoomId(roomId)==null){
            return null;
        }
        Room room = roomRepository.findByRoomId(roomId);
        List<Message> messages = room.getMessages();
        return messages;
    }
}
