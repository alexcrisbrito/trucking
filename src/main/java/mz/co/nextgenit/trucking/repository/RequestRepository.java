package mz.co.nextgenit.trucking.repository;

import mz.co.nextgenit.trucking.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<Request, UUID> {
}
