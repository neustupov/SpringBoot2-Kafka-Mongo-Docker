package org.neustupov.service;

import org.neustupov.model.Weather;
import org.neustupov.repository.WeatherRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Weather saveWeather(Weather weather) {
        return repository.save(weather);
    }
}
