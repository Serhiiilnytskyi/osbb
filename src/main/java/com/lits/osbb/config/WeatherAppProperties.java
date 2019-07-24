package com.lits.osbb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties("app.weather")
public class WeatherAppProperties {

    private final Api api = new Api();

    public Api getApi() {
        return this.api;
    }

    public static class Api {

        @NotNull
        private String key;

        public String getKey() {
            return this.key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @NotNull
        private String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

}