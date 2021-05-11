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
    @JsonIgnore
    private Long msgId;

    @Column(name = "MESSAGE_BODY")
    private String messageBody;
    @Column(name = "DATETIME_CREATED")
    private String timeStamp;
    @Column(name = "SENDER")
    private String senderUserName;
    @Column(name = "SENDER_PIC")
    private String senderPic;

    @ManyToOne
    @JoinColumn(name="CHANNEL_ID")
    @JsonIgnoreProperties("messages")
    private Channel channel;

    @ManyToOne
    @JsonIgnore
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

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    public String getSenderPic() {
        return senderPic;
    }

    public void setSenderPic(String senderPic) {
        this.senderPic = senderPic;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(msgId, message.msgId) && Objects.equals(messageBody, message.messageBody) && Objects.equals(timeStamp, message.timeStamp) && Objects.equals(senderUserName, message.senderUserName) && Objects.equals(channel, message.channel) && Objects.equals(directMessage, message.directMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgId, messageBody, timeStamp, senderUserName, senderPic, channel, directMessage);
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgId=" + msgId +
                ", messageBody='" + messageBody + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", senderUserName='" + senderUserName + '\'' +
                ", senderPic='" + senderPic + '\'' +
                ", channel=" + channel +
                ", directMessage=" + directMessage +
                '}';
    }
}