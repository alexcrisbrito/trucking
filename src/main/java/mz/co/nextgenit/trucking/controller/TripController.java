package mz.co.nextgenit.trucking.controller;

import lombok.RequiredArgsConstructor;
import mz.co.nextgenit.trucking.dto.TripRequestDto;
import mz.co.nextgenit.trucking.entity.Trip;
import mz.co.nextgenit.trucking.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/trip")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PostMapping("/create")
    public ResponseEntity<?> createTrip(@Validated @RequestBody TripRequestDto trip) {

        UUID newTripId = tripService.saveTrip(trip);

        URI location = URI.create("/api/v1/trip/" + newTripId);

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrip(@PathVariable String id) {

        Trip trip = tripService.getTripById(UUID.fromString(id));

        return ResponseEntity.ok(trip);
    }


}
