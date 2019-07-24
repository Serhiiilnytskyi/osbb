package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private Long id;

    private String city;

    private String street;

    private Integer buildingNumber;

    private Integer apartmentNumber;

}
