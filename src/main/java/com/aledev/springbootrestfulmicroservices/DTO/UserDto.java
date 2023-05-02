package com.aledev.springbootrestfulmicroservices.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
@Schema(
        description = "User dto Model information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    @Schema(
            description = "User first name"
    )
    @NotEmpty(message = "User first name should not be null or empty.")
    private String firsName;

    @Schema(
            description = "User last name"
    )
    @NotEmpty(message = " User last name should not be null or empty.")
    private String lastName;

    @Schema(
            description = "User email"
    )
    @Email(message = "Email address should not be valid.")
    @NotEmpty(message = "User Email should not be null or empty.")
    private String email;
}
