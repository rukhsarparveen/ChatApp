package com.chat_app.com.chat_app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String content;
    private String sender;
    private LocalDateTime timeStamp;

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timeStamp= LocalDateTime.now();
    }
}
