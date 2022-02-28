package tn.ehssen.Listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import tn.ehssen.entity.Tchat;

@Component
public class TchatListener {

    private static final Logger logger = LoggerFactory.getLogger(TchatListener.class);
    
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        
        if(username != null) {
            logger.info("User Disconnected : " + username);

            Tchat tchat = new Tchat();
            tchat.setMessageType(tchat.getMessageType().LEAVE);
            tchat.setSender(username);

            messagingTemplate.convertAndSend("/topic/publicChatRoom", tchat);
        }
    }
    
}