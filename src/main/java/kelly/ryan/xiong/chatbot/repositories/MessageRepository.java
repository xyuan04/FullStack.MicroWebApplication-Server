package kelly.ryan.xiong.chatbot.repositories;

import kelly.ryan.xiong.chatbot.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


    List<Message> findAllMessagesByConsumerNameAndChannelName(String consumerName, String channelName);

}
