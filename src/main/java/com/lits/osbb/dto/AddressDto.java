package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class AddressDto {

    private Long id;

    private String city;

    private String street;

    private Integer buildingNumber;

    private Integer apartmentNumber;

}
