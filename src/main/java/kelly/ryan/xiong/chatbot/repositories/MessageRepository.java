package kelly.ryan.xiong.chatbot.repositories;


import kelly.ryan.xiong.chatbot.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Iterable<Message> getMessageByChannel_Id(Long id);

}
