package mz.co.nextgenit.trucking.service;

import lombok.RequiredArgsConstructor;
import mz.co.nextgenit.trucking.dto.TripRequest;
import mz.co.nextgenit.trucking.entity.Trip;
import mz.co.nextgenit.trucking.exception.ResourceNotFoundExpection;
import mz.co.nextgenit.trucking.repository.TripRepository;
import mz.co.nextgenit.trucking.util.UniqueShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public Trip getTripById (UUID id) {
        return tripRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpection("Trip not found"));
    }

    public void saveTrip(TripRequest tripRequest) {

        Trip trip = new Trip();

        boolean exists;
        String reference;

        do {

            reference = UniqueShortCodeGenerator.generateShortCode(8);
            exists = tripRepository.existsByReference(reference);

        } while (!exists);

        trip.setReference(reference);

        tripRepository.save(trip);
    }

}
