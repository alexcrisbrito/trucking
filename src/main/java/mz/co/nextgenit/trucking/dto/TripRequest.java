package mz.co.nextgenit.trucking.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link mz.co.nextgenit.trucking.entity.Trip}
 */
@Value
public class TripRequest implements Serializable {

    @NotNull
    RequestDto request;

    @NotNull
    UUID driver;

    @NotNull
    UUID vehicle;

    @NotNull
    @PastOrPresent
    LocalDateTime started_at;
}