package vk.api.commander;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Service;
import vk.api.service.ParserWeather;
import vk.api.service.SenderMessage;

@Service
public class Weather implements ServiceCommands {

    private SenderMessage senderMessage;
    private ParserWeather parserWeather;

    public Weather(SenderMessage senderMessage, ParserWeather parserWeather) {
        this.senderMessage = senderMessage;
        this.parserWeather = parserWeather;
    }

    @Override
    public void service(Message message) throws ClientException, ApiException {
        senderMessage.sendMessage(getWeather(), message.getUserId());
    }

    private String getWeather() {
        String result = parserWeather.getWeatherTodayDescription();
        return result;
    }
}
