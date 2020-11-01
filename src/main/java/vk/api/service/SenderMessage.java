package vk.api.service;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.stereotype.Service;

@Service
public class SenderMessage {
    private VkApiClient vkApiClient;
    private GroupActor groupActor;

    public SenderMessage(VkApiClient vkApiClient, GroupActor groupActor) {
        this.vkApiClient = vkApiClient;
        this.groupActor = groupActor;
    }

    public void sendMessage(String message, int peerId) throws ClientException, ApiException {
        vkApiClient.messages().send(groupActor).peerId(peerId).message(message).execute();
    }
}
