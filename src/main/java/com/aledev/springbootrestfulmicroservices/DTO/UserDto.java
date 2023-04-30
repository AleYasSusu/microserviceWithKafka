package com.aledev.springbootrestfulmicroservices.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = "User first name should not be null or empty.")
    private String firsName;

    @NotEmpty(message = " User last name should not be null or empty.")
    private String lastName;

    @Email(message = "Email address should not be valid.")
    @NotEmpty(message = "User Email should not be null or empty.")
    private String email;
}
