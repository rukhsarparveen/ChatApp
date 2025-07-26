package com.chat_app.com.chat_app.controller;

import com.chat_app.com.chat_app.entities.Message;
import com.chat_app.com.chat_app.entities.Room;
import com.chat_app.com.chat_app.repositories.RoomRepository;
import com.chat_app.com.chat_app.services.RoomService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService,
                          RoomRepository roomRepository) {
        this.roomService = roomService;
    }

    //create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        Room room = roomService.createRoom(roomId);
        if(room==null){
            return ResponseEntity.badRequest().body("Room Already Exist!");
        }
        return ResponseEntity.ok(room);
    }

    //join room
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        Room room = roomService.joinRoom(roomId);
        if(room==null){
            return ResponseEntity.badRequest().body("Room Doesn't Exist");
        }
        return ResponseEntity.ok(room);
    }

    //get messages

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId) {
        List<Message> messages = roomService.getMessages(roomId);
        if (messages == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(messages);
    }

}
