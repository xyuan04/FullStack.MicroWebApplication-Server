package kelly.ryan.xiong.chatbot.controllers;


import kelly.ryan.xiong.chatbot.models.Channel;
import kelly.ryan.xiong.chatbot.models.Consumer;
import kelly.ryan.xiong.chatbot.models.DirectMessage;
import kelly.ryan.xiong.chatbot.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class ConsumerController {

    private ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Consumer>> findAll() {
        return ResponseEntity.ok(consumerService.findAll());
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Consumer> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(consumerService.findOne(id));
    }

    @PostMapping("/createUser")
    public ResponseEntity<Consumer> createUser(@RequestBody Consumer consumer) {
        return new ResponseEntity<Consumer>(consumerService.createConsumer(consumer),HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Consumer> updateUser(@RequestBody Consumer consumer, @PathVariable Long id) {
        return ResponseEntity.ok(consumerService.updateConsumer(consumer, id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Long id) {
        consumerService.removeConsumer(id);
        return ResponseEntity.ok("User number " + id + " has been removed.");
    }

    @GetMapping("/getchannels/{id}")
    public ResponseEntity<List<Channel>> findAllChannels(@PathVariable Long id){
        return ResponseEntity.ok(consumerService.findAllChannels(id));
    }

    @GetMapping("/getmessages/{id}")
    public ResponseEntity<List<DirectMessage>> findAllDirectMessages(@PathVariable Long id){
        return ResponseEntity.ok(consumerService.findAllDirectMessages(id));
    }


}