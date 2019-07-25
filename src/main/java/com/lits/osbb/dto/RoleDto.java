package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RoleDto {

    private Long id;

    @NotNull
    @Size(max = 64)
    private String name;

    @NotNull
    @Size(max = 128)
    private String description;
}
