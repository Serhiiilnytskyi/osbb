package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Long id;

    @NotNull
    @Size(max = 32)
    private String firstName;

    @NotNull
    @Size(max = 64)
    private String secondName;

    @NotNull
    @Size(max = 64)
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "This is not email. Please verify" )
    private String email;

    @NotNull
    @Size(max = 64)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
            message = "Password must contains uppercase letter, lowercase letter and digit. Size must be with 8 letters or more")
    private String password;

    @NotNull
    private UserDto osbbId;

    @NotNull
    private Set<RoleDto> roles;
}
