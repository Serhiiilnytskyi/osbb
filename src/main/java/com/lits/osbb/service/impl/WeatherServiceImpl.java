package com.lits.osbb.service.impl;

import com.lits.osbb.config.WeatherAppProperties;
import com.lits.osbb.dto.Weather;
import com.lits.osbb.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ExtractingResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;


import java.net.URI;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final String apiUrl;

    private final RestTemplate restTemplate;

    private final String apiKey;

    public WeatherServiceImpl(RestTemplate restTemplate, WeatherAppProperties properties) {
        this.restTemplate = restTemplate;
        this.restTemplate.setErrorHandler(new ExtractingResponseErrorHandler()); //todo chenge to own handlar
        this.apiKey = properties.getApi().getKey();
        this.apiUrl = properties.getApi().getUrl();
    }

    @Cacheable("weather")
    public Weather getWeather(String city){
        log.debug("Request current weather for city {}", city);
        log.debug("API key {} , url {}", apiKey, apiUrl);
        Weather weather = null;
        if(validParameters(city)) {
            URI url = new UriTemplate(this.apiUrl).expand(city, this.apiKey);

            weather = invoke(url, Weather.class);
        }
        return weather;
    }

    private boolean validParameters(String city) {
        return city !=null && !"".equals(city) && apiKey !=null && !"".equals(apiKey) && apiUrl!=null && !"".equals(apiUrl);
    }

    private <T> T invoke(URI url, Class<T> responseType){
        T weather = null;
        try {
            RequestEntity<?> request = RequestEntity.get(url)
                    .accept(MediaType.APPLICATION_JSON).build();
            ResponseEntity<T> exchange = this.restTemplate
                    .exchange(request, responseType);
            weather = exchange.getBody();
        } catch(Exception e){
            log.error("An error occurred while calling openweathermap.org API endpoint:  " + e.getMessage());
        }

        return weather;
    }
}