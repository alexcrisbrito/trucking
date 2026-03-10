package mz.co.nextgenit.trucking;

import mz.co.nextgenit.trucking.dto.TripRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TruckingApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldCreateANewTrip() {

        TripRequestDto requestDto = new TripRequestDto(
                "52.208706657501146,20.926131878", "52.17248392506608,20.972550456186575",
                50L, "50x50x50", "375fd2fc-328e-4b3f-9d69-dda50c2d8077"
        );

        ResponseEntity<?> getResponse = restTemplate.postForEntity("/api/v1/trip/create", requestDto , String.class);

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        var newLocation = restTemplate.getForEntity(getResponse.getHeaders().getLocation(), String.class);
        assertThat(newLocation.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
