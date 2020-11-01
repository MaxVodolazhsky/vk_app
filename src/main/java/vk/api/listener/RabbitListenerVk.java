package vk.api.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import vk.api.parser.ParseCommands;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class RabbitListenerVk {

    private ParseCommands parseCommands;
    private final Gson gson;

    public RabbitListenerVk(ParseCommands parseCommands, Gson gson) {
        this.parseCommands = parseCommands;
        this.gson = gson;
    }

    @RabbitListener(queues = "hello")
    public void rabbitListener(Message message) throws ClientException, ApiException, IOException {
        com.vk.api.sdk.objects.messages.Message m = gson.fromJson(new String(message.getBody(), StandardCharsets.UTF_8), com.vk.api.sdk.objects.messages.Message.class);
        parseCommands.parseCommands(m);
    }
}
