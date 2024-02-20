package org.example;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;

import java.io.StringReader;

public class MessageDecoder implements Decoder.Text<Message>{
    @Override
    public Message decode(String jsonMessage) throws DecodeException {

        JsonObject jsonObject = Json
                .createReader(new StringReader(jsonMessage)).readObject();
        Message message = new Message();
        message.setSubject(jsonObject.getString("subject"));
        message.setContent(jsonObject.getString("content"));
        return message;

    }

    @Override
    public boolean willDecode(String jsonMessage) {
        try {
            // Check if incoming message is valid JSON
            Json.createReader(new StringReader(jsonMessage)).readObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public void destroy() {
        System.out.println("MessageDecoder - destroy method called");
    }
}
