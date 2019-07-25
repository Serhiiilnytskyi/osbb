package com.lits.osbb.controller;

import com.lits.osbb.config.WeatherAppProperties;
import com.lits.osbb.dto.Weather;
import com.lits.osbb.dto.WeatherSearchQuery;
import com.lits.osbb.dto.WeatherSummary;
import com.lits.osbb.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@CrossOrigin("*")
public class WeatherSearchController {

    private final WeatherService weatherService;

    private final WeatherAppProperties properties;

    public WeatherSearchController(WeatherService weatherService, WeatherAppProperties properties) {
        this.weatherService = weatherService;
        this.properties = properties;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/weather_search")
    public ResponseEntity<?> searchWeather(@RequestParam String city) {
        WeatherSearchQuery query = new WeatherSearchQuery(city);
        log.debug("Received request to search weather in city {}", city);
        List<WeatherSummary> weatherSummaryList = new ArrayList<>();

        if (!"".equals(query.getCity())) {
            weatherSummaryList = getSummary(query.getCity());
            if (weatherSummaryList != null && weatherSummaryList.size() > 0) {
            }
        }
        return ResponseEntity.ok(weatherSummaryList);
    }

    protected List<WeatherSummary> getSummary(String city) {
        List<WeatherSummary> summary = new ArrayList<>();
        Weather weather = this.weatherService.getWeather(city);
        if (weather != null) {
            summary.add(new WeatherSummary(city, weather));
        }
        return summary;
    }
}

