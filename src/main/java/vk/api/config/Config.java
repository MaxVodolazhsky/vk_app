package vk.api.config;

import com.google.gson.Gson;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class Config {

    @Bean
    public VkApiClient getVkApiClient() {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        return vk;
    }

    @Bean
    public GroupActor getActor(@Value("${app.vk.access_token}") String access_token,
                               @Value("${app.vk.group_id}") int groupId) {
        GroupActor actor = new GroupActor(groupId, access_token);
        return actor;
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
