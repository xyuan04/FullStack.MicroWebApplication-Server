package kelly.ryan.xiong.chatbot.controllerTest;

import kelly.ryan.xiong.chatbot.controllers.MessageController;
import kelly.ryan.xiong.chatbot.models.Message;
import kelly.ryan.xiong.chatbot.repositories.MessageRepository;
import kelly.ryan.xiong.chatbot.services.MessageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.anyLong;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    @MockBean
    MessageRepository repository;

    @Autowired
    MockMvc mvc;

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

//        ResponseEntity<Message> returnedMsg = messageController.getMessageById(1L);
//
//        Assert.assertTrue(returnedMsg.getBody().getMessageBody().equals("Hi Bob."));
//    }
//
//}
