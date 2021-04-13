package org.neustupov.listener;

import org.neustupov.model.Weather;
import org.neustupov.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class MessageListener {

    @Autowired
    private WeatherService service;

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listener(Weather weather){
        System.out.println("Recieved message: " + weather);
        service.saveWeather(weather);
    }
}
