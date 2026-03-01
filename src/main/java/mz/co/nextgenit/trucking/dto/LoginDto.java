package mz.co.nextgenit.trucking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link mz.co.nextgenit.trucking.entity.User}
 */
@AllArgsConstructor
@Getter
public class LoginDto implements Serializable {

    @NotBlank
    @NotNull
    private final String username;

    @NotBlank
    @NotNull
    private final String password;
}