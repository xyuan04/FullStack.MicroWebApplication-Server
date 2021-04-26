package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class DirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "ID")
    private List<User> users;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "ID")
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
        DirectMessage that = (DirectMessage) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(users, that.users) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users, messages);
    }

    @Override
    public String toString() {
        return "DirectMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", messages=" + messages +
                '}';
    }
}
