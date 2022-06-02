package kafkatutorial.service;

import kafkatutorial.model.SimpleStringMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String extractMessageText(SimpleStringMessage message) {
        return message.getMessageText();
    }
}
