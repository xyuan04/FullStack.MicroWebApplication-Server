package kelly.ryan.xiong.chatbot.services;

import kelly.ryan.xiong.chatbot.models.Channel;
import kelly.ryan.xiong.chatbot.models.Consumer;
import kelly.ryan.xiong.chatbot.models.DirectMessage;
import kelly.ryan.xiong.chatbot.repositories.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {

    private ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public List<Consumer> findAll() {
        return new ArrayList<Consumer>(consumerRepository.findAll());
    }

    public Consumer findOne(Long id) {
        return consumerRepository.findById(id).get();
    }


    public Consumer createConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }


    public Consumer updateConsumer(Consumer u, Long id) {
        Consumer consumer = new Consumer();

        consumer.setName(u.getName());
        consumer.setUserName(u.getUserName());
        consumer.setPassword(u.getPassword());
        consumer.setEmail(u.getEmail());

        return consumer;
    }

    public Boolean removeConsumer(Long id) {
        consumerRepository.delete(consumerRepository.getOne(id));
        return true;
    }

    public List<Channel> findAllChannels(Long id){
        Consumer consumer = findOne(id);
        return consumer.getChannelList();
    }

    public List<DirectMessage> findAllDirectMessages(Long id){
        Consumer consumer = findOne(id);
        return consumer.getDirectMessages();
    }
}