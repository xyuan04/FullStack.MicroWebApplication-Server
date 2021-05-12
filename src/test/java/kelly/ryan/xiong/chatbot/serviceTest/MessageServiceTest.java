package kelly.ryan.xiong.chatbot.serviceTest;
import kelly.ryan.xiong.chatbot.models.Message;
import kelly.ryan.xiong.chatbot.repositories.MessageRepository;
import kelly.ryan.xiong.chatbot.services.MessageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    MessageService messageService;
    @InjectMocks
    MessageRepository messageRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void createMessageTest() {
        Message testMessage = new Message();
        testMessage.setMessageBody("Hi Bob.");
        Mockito.when(messageRepository.save(any())).thenReturn(testMessage);
        Message returnedMsg = messageService.createMessage(new Message());
        Assert.assertTrue(returnedMsg.getMessageBody().equals("Hi Bob."));
    }
}