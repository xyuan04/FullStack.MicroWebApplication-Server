package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHANNEL_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany
    @JoinColumn(name = "CHANNEL_ID")
    @JsonIgnore
    private List<User> users;
    @OneToMany
    @JoinColumn(name = "MESSAGE_ID")
    @JsonIgnore
    private List<Message> messages;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(id, channel.id) && Objects.equals(name, channel.name) && Objects.equals(users, channel.users) && Objects.equals(messages, channel.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users, messages);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", messages=" + messages +
                '}';
    }
}
