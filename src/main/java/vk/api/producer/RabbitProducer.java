package vk.api.producer;

import com.google.gson.Gson;
import com.vk.api.sdk.objects.messages.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitProducer {
    private static final String EXCHANGE = "vk.api";
    private final RabbitTemplate rabbitTemplate;

    private final Gson gson;

    public RabbitProducer(RabbitTemplate rabbitTemplate, Gson gson) {
        this.rabbitTemplate = rabbitTemplate;
        this.gson = gson;
    }

    public void putInQueue(Message message) {
        rabbitTemplate.setDefaultReceiveQueue("hello");
        log.info("put in queue [message = {}]", message);
        rabbitTemplate.send(EXCHANGE, "", MessageBuilder.withBody(gson.toJson(message).getBytes()).build());
    }
}
