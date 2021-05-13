package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    @Column(name = "PICTURE")
    private String profilePicture = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHe330tYy_U_3UN0DmUSbGoFbXigdIQglDAA&usqp=CAU";
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return Objects.equals(id, consumer.id) && Objects.equals(name, consumer.name) && Objects.equals(userName, consumer.userName) && Objects.equals(password, consumer.password) && Objects.equals(email, consumer.email) && Objects.equals(profilePicture, consumer.profilePicture) && Objects.equals(channelList, consumer.channelList) && Objects.equals(directMessages, consumer.directMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, password, email, profilePicture, channelList, directMessages);
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", channelList=" + channelList +
                ", directMessages=" + directMessages +
                '}';
    }
}