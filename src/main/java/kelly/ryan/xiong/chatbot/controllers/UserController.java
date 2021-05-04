package kelly.ryan.xiong.chatbot.controllers;


import kelly.ryan.xiong.chatbot.models.Channel;
import kelly.ryan.xiong.chatbot.models.DirectMessage;
import kelly.ryan.xiong.chatbot.models.User;
import kelly.ryan.xiong.chatbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findOne(id));
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.ok(userService.updateUser(user, id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Long id) {
        userService.removeUser(id);
        return ResponseEntity.ok("User number " + id + " has been removed.");
    }

    @GetMapping("/getchannels/{id}")
    public ResponseEntity<List<Channel>> findAllChannels(@PathVariable Long id){
        return ResponseEntity.ok(userService.findAllChannels(id));
    }

    @GetMapping("/getmessages/{id}")
    public ResponseEntity<List<DirectMessage>> findAllDirectMessages(@PathVariable Long id){
        return ResponseEntity.ok(userService.findAllDirectMessages(id));
    }


}