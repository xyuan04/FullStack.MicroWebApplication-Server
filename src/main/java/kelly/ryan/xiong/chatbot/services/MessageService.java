package kelly.ryan.xiong.chatbot.services;


import kelly.ryan.xiong.chatbot.models.Message;
import kelly.ryan.xiong.chatbot.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message findMessage(Long msgId) {
        return messageRepository.findById(msgId).get();
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> findAllUserSentMessages(Long userId) {
        // find all messages that have userId as the id of the senderId field of message
        return null;
    }

    public List<Message> findAllUserReceivedMessages(Long userId) {
        // find all messages that have userId as the id of the recipient field of message
        return null;
    }

    public List<Message> findAllUserSentAndReceivedMessages(Long userId) {
        // find all messages that have userId as the id of either the recipient or sender field of message
        return null;
    }

//    public Message updateMessageById(Long msgId, Message newMessageData) {
//        Message ogMessage = messageRepository.findById(msgId).get();
//
//        ogMessage.s
//    }

}
