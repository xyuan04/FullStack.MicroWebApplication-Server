package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long msgId;

    @Column(name = "MESSAGE_BODY")
    private String messageBody;

    @Column(name = "DATETIME_CREATED")
    private Date timeStamp;

    @Column(name = "USER_SENDER_ID")
    private Long senderId;

    @ManyToOne
    private Channel channel;

    @ManyToOne
    @JsonIgnoreProperties("messages")
    private DirectMessage directMessage;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public DirectMessage getDirectMessage() {
        return directMessage;
    }

    public void setDirectMessage(DirectMessage directMessage) {
        this.directMessage = directMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(msgId, message.msgId) && Objects.equals(messageBody, message.messageBody) && Objects.equals(timeStamp, message.timeStamp) && Objects.equals(senderId, message.senderId) && Objects.equals(channel, message.channel) && Objects.equals(directMessage, message.directMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgId, messageBody, timeStamp, senderId, channel, directMessage);
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgId=" + msgId +
                ", messageBody='" + messageBody + '\'' +
                ", timeStamp=" + timeStamp +
                ", senderId=" + senderId +
                ", channel=" + channel +
                ", directMessageId=" + directMessage +
                '}';
    }
}