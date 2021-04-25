package kelly.ryan.xiong.chatbot.repositories;

import kelly.ryan.xiong.chatbot.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
