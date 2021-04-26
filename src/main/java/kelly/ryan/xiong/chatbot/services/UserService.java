package kelly.ryan.xiong.chatbot.services;

import kelly.ryan.xiong.chatbot.models.User;
import kelly.ryan.xiong.chatbot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return new ArrayList<User>(userRepository.findAll());
    }

    public User findOne(Long id) {
        return userRepository.findById(id).get();
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(User u, Long id) {
        User user = new User();

        user.setName(u.getName());
        user.setUserName(u.getUserName());
        user.setPassword(u.getPassword());
        user.setEmail(u.getEmail());

        return user;
    }

    public Boolean removeUser(Long id) {
        userRepository.delete(userRepository.getOne(id));
        return true;
    }
}
