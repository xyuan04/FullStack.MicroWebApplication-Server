package kelly.ryan.xiong.chatbot.repositories;

import kelly.ryan.xiong.chatbot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepository extends JpaRepository<User,Long> {
}
