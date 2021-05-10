package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONSUMER")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSUMER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @ManyToMany(mappedBy = "consumers", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("consumers")
    private List<Channel> channelList;
    @ManyToMany(mappedBy = "consumers", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("consumers")
    private List<DirectMessage> directMessages;

    public Consumer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public List<DirectMessage> getDirectMessages(){return directMessages;}

    public void setDirectMessages(List<DirectMessage> directMessages) {
        this.directMessages = directMessages;
    }
}