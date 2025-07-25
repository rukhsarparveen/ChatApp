package com.chat_app.com.chat_app.services;

import com.chat_app.com.chat_app.entities.Message;
import com.chat_app.com.chat_app.entities.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(String roomId);

    Room joinRoom(String roomId);

    List<Message> getMessages(String roomId);
}
