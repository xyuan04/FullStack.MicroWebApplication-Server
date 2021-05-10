package kelly.ryan.xiong.chatbot.services;

import kelly.ryan.xiong.chatbot.models.Channel;
import kelly.ryan.xiong.chatbot.models.Consumer;
import kelly.ryan.xiong.chatbot.repositories.ChannelRepository;
import kelly.ryan.xiong.chatbot.repositories.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {
    private ChannelRepository channelRepository;
    private ConsumerRepository consumerRepository;

    @Autowired
    public ChannelService(ChannelRepository channelRepository, ConsumerRepository consumerRepository) {
        this.channelRepository = channelRepository;
        this.consumerRepository = consumerRepository;
    }

    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    public Channel findChannel(Long id) {
        return channelRepository.findById(id).get();
    }

    public List<Channel> findAllChannels() {
        return new ArrayList<>(channelRepository.findAll());
    }

    public Channel updateChannel(Long id, Channel channel) {
        channel.setId(id);

        return channelRepository.save(channel);
    }

    public Boolean deleteChannel(Long id) {
        try{
            channelRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteAllChannels() {
        findAllChannels().forEach(channel -> deleteChannel(channel.getId()));
        return true;
    }

    public List<Channel> findChannelsByConsumerId(Long id) {
        Consumer consumer = consumerRepository.findById(id).get();
        return consumer.getChannelList();
    }

}
