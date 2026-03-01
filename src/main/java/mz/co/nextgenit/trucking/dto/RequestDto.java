package mz.co.nextgenit.trucking.dto;

import jakarta.validation.constraints.*;
import mz.co.nextgenit.trucking.entity.Request;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Request}
 */
public record RequestDto(@NotNull(message = "Client should not be null") UUID companyClientId,
                         @NotNull @NotEmpty @NotBlank String startingPoint,
                         @NotNull @NotEmpty @NotBlank String endingPoint, @Min(1) @Positive long proposedPrice,
                         @Min(1) @Max(9999999) @Positive long weightKg,
                         @Min(1) @PositiveOrZero long volumeM3) implements Serializable {

}