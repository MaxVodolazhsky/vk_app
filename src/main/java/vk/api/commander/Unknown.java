package vk.api.commander;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Service;
import vk.api.service.SenderMessage;

@Service
public class Unknown implements ServiceCommands {

    private SenderMessage senderMessage;

    public Unknown(SenderMessage senderMessage) {
        this.senderMessage = senderMessage;
    }

    @Override
    public void service(Message message) throws ClientException, ApiException {
        senderMessage.sendMessage("Неизвестная команда", message.getUserId());
    }
}
