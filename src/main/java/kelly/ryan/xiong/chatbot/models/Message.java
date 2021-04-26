package kelly.ryan.xiong.chatbot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long msgId;
    private String messageBody;
    private Date timeStamp;
    private Long senderId;
    private Long channelId;
    private Long directMessageId;

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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getDirectMessageId() {
        return directMessageId;
    }

    public void setDirectMessageId(Long directMessageId) {
        this.directMessageId = directMessageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(msgId, message.msgId) && Objects.equals(messageBody, message.messageBody) && Objects.equals(timeStamp, message.timeStamp) && Objects.equals(senderId, message.senderId) && Objects.equals(channelId, message.channelId) && Objects.equals(directMessageId, message.directMessageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgId, messageBody, timeStamp, senderId, channelId, directMessageId);
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgId=" + msgId +
                ", messageBody='" + messageBody + '\'' +
                ", timeStamp=" + timeStamp +
                ", senderId=" + senderId +
                ", channelId=" + channelId +
                ", directMessageId=" + directMessageId +
                '}';
    }
}