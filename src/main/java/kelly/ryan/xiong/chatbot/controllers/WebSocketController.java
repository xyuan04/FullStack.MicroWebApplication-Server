package kelly.ryan.xiong.chatbot.controllers;

import kelly.ryan.xiong.chatbot.models.Message;
import kelly.ryan.xiong.chatbot.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    MessageService messageService;

    @Autowired
    public WebSocketController(MessageService messageService) {
        this.messageService = messageService;
    }

//    @MessageMapping("/chat.send")
//    @SendTo("/topic/channel")
//    public Message registerMessage(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
//        headerAccessor.getSessionAttributes().put("user_ID", message.getSenderId());
//        return message;
//    }

    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return messageService.createMessage(message);
    }
}
