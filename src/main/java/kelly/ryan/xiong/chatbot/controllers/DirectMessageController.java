package kelly.ryan.xiong.chatbot.controllers;

import kelly.ryan.xiong.chatbot.models.DirectMessage;
import kelly.ryan.xiong.chatbot.services.DirectMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dm")
public class DirectMessageController {
    private DirectMessageService directMessageService;
    
    public DirectMessageController(DirectMessageService directMessageService) {
        this.directMessageService = directMessageService;
    }

    @PostMapping
    public ResponseEntity<DirectMessage> createDirectMessage(@RequestBody DirectMessage directMessage) {
        return new ResponseEntity<>(directMessageService.createDirectMessage(directMessage), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DirectMessage>> findAllDirectMessages() {
        return new ResponseEntity<>(directMessageService.findAllDirectMessages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectMessage> findDirectMessage(@PathVariable Long id) {
        return new ResponseEntity<>(directMessageService.findDirectMessage(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectMessage> updateDirectMessage(@PathVariable Long id, @RequestBody DirectMessage directMessage) {
        return new ResponseEntity<>(directMessageService.updateDirectMessage(id, directMessage), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDirectMessage(@PathVariable Long id) {
        return new ResponseEntity<>(directMessageService.deleteDirectMessage(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllDirectMessages() {
        return new ResponseEntity<>(directMessageService.deleteAllDirectMessages(), HttpStatus.NO_CONTENT);
    }
}
