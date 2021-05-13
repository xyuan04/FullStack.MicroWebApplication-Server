package kelly.ryan.xiong.chatbot.repositories;

import kelly.ryan.xiong.chatbot.models.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long> {

    Consumer findByUserNameAndPassword(String userName, String password);
}
