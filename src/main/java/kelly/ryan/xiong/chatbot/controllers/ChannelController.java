package kelly.ryan.xiong.chatbot.controllers;

import kelly.ryan.xiong.chatbot.models.Channel;
import kelly.ryan.xiong.chatbot.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Channel")
public class ChannelController {
    private ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        return new ResponseEntity<>(channelService.createChannel(channel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Channel>> findAllChannels() {
        return new ResponseEntity<>(channelService.findAllChannels(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Channel> findChannel(@PathVariable Long id) {
        return new ResponseEntity<>(channelService.findChannel(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Channel> updateChannel(@PathVariable Long id, @RequestBody Channel channel) {
        return new ResponseEntity<>(channelService.updateChannel(id, channel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteChannel(@PathVariable Long id) {
        return new ResponseEntity<>(channelService.deleteChannel(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllChannels() {
        return new ResponseEntity<>(channelService.deleteAllChannels(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/User/{id}/Channels")
    public ResponseEntity<List<Channel>> getChannelsByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(channelService.findChannelsByConsumerId(id), HttpStatus.OK);
    }
}
