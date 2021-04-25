package kelly.ryan.xiong.chatbot.repositories;

import kelly.ryan.xiong.chatbot.models.DirectMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectMessageRepository extends JpaRepository<DirectMessage, Long> {
}
