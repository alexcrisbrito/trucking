package mz.co.nextgenit.trucking.service;

import lombok.RequiredArgsConstructor;
import mz.co.nextgenit.trucking.dto.TripRequestDto;
import mz.co.nextgenit.trucking.entity.CompanyClient;
import mz.co.nextgenit.trucking.entity.Trip;
import mz.co.nextgenit.trucking.exception.BadRequestException;
import mz.co.nextgenit.trucking.exception.ResourceNotFoundExpection;
import mz.co.nextgenit.trucking.repository.CompanyClientRepository;
import mz.co.nextgenit.trucking.repository.TripRepository;
import mz.co.nextgenit.trucking.util.UniqueShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final CompanyClientRepository companyClientRepository;

    public Trip getTripById (UUID id) {
        return tripRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpection("Trip not found"));
    }

    public UUID saveTrip(TripRequestDto tripRequest) {

        Optional<CompanyClient> companyClient = companyClientRepository.findById(UUID.fromString(tripRequest.companyClientId()));

        if (companyClient.isEmpty())
            throw new BadRequestException("Invalid company client id");

        String reference = UniqueShortCodeGenerator.generateShortCode(8);

        Trip trip = new Trip();
        trip.setCompanyClient(companyClient.get());
        trip.setStartingPoint(tripRequest.startingPoint());
        trip.setEndingPoint(tripRequest.endingPoint());
        trip.setWeightKg(tripRequest.weightKg());
        trip.setDimensions(tripRequest.dimensions());
        trip.setReference(reference);

        tripRepository.save(trip);

        return trip.getId();
    }

}
