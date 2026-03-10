package mz.co.nextgenit.trucking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

/**
 * DTO for {@link mz.co.nextgenit.trucking.entity.Trip}
 */
public record TripRequestDto(@NotBlank String startingPoint, @NotBlank String endingPoint,@Positive long weightKg,
                             @NotBlank String dimensions,@NotBlank String companyClientId) implements Serializable {
}