package com.lits.osbb.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OsbbDto {

    private Long id;

    @NotNull
    @Size(max = 64)
    private String name;

    private List<UserDto> members = new ArrayList<>();

    private Set<AddressDto> address = new HashSet<>();
}
