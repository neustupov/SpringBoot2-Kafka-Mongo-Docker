package org.neustupov.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.neustupov.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiServiceImpl implements ApiService{

  RestTemplate restTemplate;
  String apiUrl;
  String apiKey;
  String location;

  public ApiServiceImpl(RestTemplate restTemplate,
      @Value("${api_url}") String apiUrl,
      @Value("${api_key}") String apiKey,
      @Value("${location}") String location) {
    this.restTemplate = restTemplate;
    this.apiUrl = apiUrl;
    this.apiKey = apiKey;
    this.location = location;
  }

  @Override
  public Weather getWeather() {
    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(apiUrl)
        .queryParam("key", apiKey)
        .queryParam("q", location)
        .queryParam("aqi", "no");

    return restTemplate.getForObject(builder.toUriString(), Weather.class);
  }
}
