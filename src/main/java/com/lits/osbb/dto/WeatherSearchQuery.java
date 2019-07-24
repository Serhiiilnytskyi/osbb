package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class WeatherSearchQuery {

    @NotNull
    private String city;

}
