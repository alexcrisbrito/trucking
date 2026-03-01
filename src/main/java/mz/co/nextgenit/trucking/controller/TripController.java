package mz.co.nextgenit.trucking.controller;

import lombok.RequiredArgsConstructor;
import mz.co.nextgenit.trucking.dto.TripRequest;
import mz.co.nextgenit.trucking.entity.Trip;
import mz.co.nextgenit.trucking.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/trip")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrip(@PathVariable UUID id) {

        Trip trip = tripService.getTripById(id);

        return ResponseEntity.ok(trip);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTrip(@RequestBody @Validated TripRequest tripRequest) {

        tripService.saveTrip(tripRequest);

        return ResponseEntity.ok().build();
    }

}
