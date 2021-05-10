package kelly.ryan.xiong.chatbot.services;

import kelly.ryan.xiong.chatbot.models.DirectMessage;
import kelly.ryan.xiong.chatbot.repositories.DirectMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectMessageService {
    private DirectMessageRepository directMessageRepository;

    @Autowired
    public DirectMessageService(DirectMessageRepository directMessageRepository) {
        this.directMessageRepository = directMessageRepository;
    }

    public DirectMessage createDirectMessage(DirectMessage directMessage) {
        return directMessageRepository.save(directMessage);
    }

    public DirectMessage findDirectMessage(Long id) {
        return directMessageRepository.findById(id).get();
    }

    public List<DirectMessage> findAllDirectMessages() {
        return new ArrayList<>(directMessageRepository.findAll());
    }

    public DirectMessage updateDirectMessage(Long id, DirectMessage directMessage) {
        DirectMessage ogDirectMessage = directMessageRepository.findById(id).get();

        ogDirectMessage.setName(directMessage.getName());
        ogDirectMessage.setConsumers(directMessage.getConsumers());
        ogDirectMessage.setMessages(directMessage.getMessages());

        return directMessageRepository.save(ogDirectMessage);
    }

    public Boolean deleteDirectMessage(Long id) {
        try{
            directMessageRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteAllDirectMessages() {
        findAllDirectMessages().forEach(dm -> deleteDirectMessage(dm.getId()));
        return true;
    }
}
