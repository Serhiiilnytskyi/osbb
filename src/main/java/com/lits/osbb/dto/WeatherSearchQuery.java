package com.lits.osbb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class WeatherSearchQuery {

    @NotNull
    private String city;

}
