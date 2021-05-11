package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class DirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DM_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("consumers")
    private List<Consumer> consumers;
    @OneToMany(mappedBy = "directMessage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("directMessage")
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

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
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
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(consumers, that.consumers) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, consumers, messages);
    }

    @Override
    public String toString() {
        return "DirectMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", consumers=" + consumers +
                ", messages=" + messages +
                '}';
    }
}
