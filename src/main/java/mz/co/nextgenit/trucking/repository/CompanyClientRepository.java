package mz.co.nextgenit.trucking.repository;

import mz.co.nextgenit.trucking.entity.CompanyClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyClientRepository extends JpaRepository<CompanyClient, UUID> {


}
