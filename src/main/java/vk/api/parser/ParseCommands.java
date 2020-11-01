package vk.api.parser;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Service;
import vk.api.commander.Unknown;
import vk.api.commander.Weather;

@Service
public class ParseCommands {

    private final Weather weather;
    private final Unknown unknown;

    public ParseCommands(Weather weather, Unknown unknown) {
        this.weather = weather;
        this.unknown = unknown;
    }

    public void parseCommands(Message message) throws ClientException, ApiException {
        switch (message.getBody()) {
            case ("Погода") : {
                weather.service(message);
                break;
            }

            default: unknown.service(message);
        }
    }

}
