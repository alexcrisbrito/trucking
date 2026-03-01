package mz.co.nextgenit.trucking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link mz.co.nextgenit.trucking.entity.Request}
 */
@AllArgsConstructor
@Getter
@Setter
public class RequestResponse implements Serializable {
    private final UUID id;
    private final UUID company_partnerId;
    private final String starting_point;
    private final String ending_point;
    private final long proposed_price;
    private final long weight_kg;
    private final long volume_m3;
}