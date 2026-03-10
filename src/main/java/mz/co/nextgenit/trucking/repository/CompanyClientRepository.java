package mz.co.nextgenit.trucking.repository;

import mz.co.nextgenit.trucking.entity.CompanyClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyClientRepository extends CrudRepository<CompanyClient, UUID> {

}
