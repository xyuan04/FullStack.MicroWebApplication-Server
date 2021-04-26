package kelly.ryan.xiong.chatbot.services;

import kelly.ryan.xiong.chatbot.models.Channel;
import kelly.ryan.xiong.chatbot.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {
    private ChannelRepository channelRepository;

    @Autowired
    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
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
        Channel ogChannel = channelRepository.findById(id).get();

        ogChannel.setName(channel.getName());
        ogChannel.setUsers(channel.getUsers());
        ogChannel.setMessages(channel.getMessages());

        return channelRepository.save(ogChannel);
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

}
