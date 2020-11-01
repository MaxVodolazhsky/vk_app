package vk.api.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParserWeather {
    private String city = "nizhny_novgorod";
    private Document doc;

    public ParserWeather() throws IOException {
        doc = Jsoup.connect(String.format("https://world-weather.ru/pogoda/russia/%s/",city)).get();
    }
    ParserWeather(String city) throws IOException {
        this.city = city;
        doc = Jsoup.connect(String.format("https://world-weather.ru/pogoda/russia/%s/",city)).get();
    }


    public String getWeatherTodayDescription() {
        Elements elements = doc.select("span.dw-into");
        return elements.text().split("Подробнее")[0];
    }

}
