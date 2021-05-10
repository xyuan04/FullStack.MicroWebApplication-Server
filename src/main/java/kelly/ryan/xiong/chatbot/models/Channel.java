package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("consumers")
    private List<Consumer> consumers;
    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("channel")
    private List<Message> messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Channel channel = (Channel) o;
        return Objects.equals(id, channel.id) && Objects.equals(name, channel.name) && Objects.equals(consumers, channel.consumers) && Objects.equals(messages, channel.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, consumers, messages);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", consumers=" + consumers +
                ", messages=" + messages +
                '}';
    }
}
