package kelly.ryan.xiong.chatbot.controllerTest;
import kelly.ryan.xiong.chatbot.controllers.MessageController;
import kelly.ryan.xiong.chatbot.models.Message;
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
import org.springframework.http.ResponseEntity;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    @Mock
    MessageController messageController;
    @InjectMocks
    MessageService messageService;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getMessageByIdTest() throws Exception {
        Message testMessage = new Message();
        testMessage.setMessageBody("Hi Bob.");
        Mockito.when(messageService.findMessage(anyLong())).thenReturn(testMessage);
        ResponseEntity<Message> returnedMsg = messageController.getMessageById(1L);
        Assert.assertTrue(returnedMsg.getBody().getMessageBody().equals("Hi Bob."));
    }
}