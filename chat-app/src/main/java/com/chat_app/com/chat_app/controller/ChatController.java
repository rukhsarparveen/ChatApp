package com.chat_app.com.chat_app.controller;

import com.chat_app.com.chat_app.entities.Message;
import com.chat_app.com.chat_app.entities.Room;
import com.chat_app.com.chat_app.payload.MessageRequest;
import com.chat_app.com.chat_app.repositories.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("http://localhost:3000")
public class ChatController {

    private RoomRepository roomRepository;
    public ChatController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }


    //for sending and receiving messages

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ){
        Room room = roomRepository.findByRoomId(request.getRoomId());
        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());
        if (room!=null){
            room.getMessages().add(message);
            roomRepository.save(room);
        }
        else{
            throw new RuntimeException("room not found!");
        }
        return message;
    }
}
