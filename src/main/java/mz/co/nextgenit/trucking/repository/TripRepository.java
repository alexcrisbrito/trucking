package mz.co.nextgenit.trucking.repository;

import mz.co.nextgenit.trucking.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {
    boolean existsByReference(String reference);
}
