package kelly.ryan.xiong.chatbot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String email;
//    private List<Channel> channelList;



}
