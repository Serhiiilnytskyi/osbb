package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddressDto {

    private Long id;

    @NotNull
    @Size(max = 64)
    private String city;

    @NotNull
    @Size(max = 128)
    private String street;

    @NotNull
    private Integer buildingNumber;

    private Integer apartmentNumber;

}
