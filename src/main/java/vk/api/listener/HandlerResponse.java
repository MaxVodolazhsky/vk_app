package vk.api.listener;


import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vk.api.parser.ParseCommands;
import vk.api.core.VkCore;
import vk.api.producer.RabbitProducer;

import java.util.List;

@Component
public class HandlerResponse {

    private final VkCore vkCore;
    private final ParseCommands parseCommands;
    private final RabbitProducer rabbitProducer;

    public HandlerResponse(VkCore vkCore, ParseCommands parseCommands, RabbitProducer rabbitProducer) {
        this.vkCore = vkCore;
        this.parseCommands = parseCommands;
        this.rabbitProducer = rabbitProducer;
    }

    @Scheduled(fixedDelay = 300)
    public void listener() throws ClientException, ApiException {
        List<Message> messages = vkCore.getMessage();
        if (messages != null) {
            for (Message message : messages) {
                rabbitProducer.putInQueue(message);
            }
        }
    }
}
