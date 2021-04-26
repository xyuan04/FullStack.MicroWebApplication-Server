package kelly.ryan.xiong.chatbot.controllers;

import kelly.ryan.xiong.chatbot.models.Message;
import kelly.ryan.xiong.chatbot.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{msgId}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long msgId) {
        return new ResponseEntity<>(messageService.findMessage(msgId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return new ResponseEntity<>(messageService.findAllMessages(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.createMessage(message), HttpStatus.CREATED);
    }
    @PutMapping("/{msgId}")
    public ResponseEntity<Message> updateMessageById(@PathVariable Long msgId, @RequestBody Message message) {
        return new ResponseEntity<>(messageService.updateMessageById(msgId, message), HttpStatus.OK);
    }
    @DeleteMapping("/{msgId}")
    public ResponseEntity<Boolean> deleteMessageById(@PathVariable Long msgId) {
        return new ResponseEntity<>(messageService.deleteMessageById(msgId), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAllMessages() {
        messageService.deleteAllMessages();
        return ResponseEntity.ok("All messages have been deleted.");
    }
}