package vk.api.commander;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCommands {

    void service(Message message) throws ClientException, ApiException;
}
