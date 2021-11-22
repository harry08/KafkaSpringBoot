package kafkatutorial.service;

import kafkatutorial.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String extractMessageText(Message message) {
        return message.getMessageText();
    }
}
