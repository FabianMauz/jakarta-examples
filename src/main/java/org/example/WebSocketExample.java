package org.example;



import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint(
        value = "/websocket-test",
        encoders = { StringEncoder.class },
        decoders = { MessageDecoder.class }
)
public class WebSocketExample {
    private boolean isActive=false;
    private Session session;
    private DateFormat sdf=new SimpleDateFormat(("HH:mm:ss"));
    @OnOpen
    public void onOpen(Session session) {
        this.session=session;
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Stock information received: " + message + " from " + session.getId());
        try {
            session.getBasicRemote().sendObject("Hey Serj");
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
        if(!isActive){
            try {
                triggerLoop();
            }catch(Exception e){

            }
        }
    }

    private void triggerLoop() throws InterruptedException, EncodeException, IOException {
        isActive=true;
        while(true){
            Thread.sleep(1000);
            session.getBasicRemote().sendObject("Hey Serj "+sdf.format(new Date()));
        }
    }
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error for " + session.getId() + " " + throwable.getMessage());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket closed for " + session.getId()
                + " with reason " + closeReason.getCloseCode());
    }
}
