package mz.co.nextgenit.trucking.service;

import lombok.RequiredArgsConstructor;
import mz.co.nextgenit.trucking.dto.RequestDto;
import mz.co.nextgenit.trucking.entity.CompanyClient;
import mz.co.nextgenit.trucking.entity.Request;
import mz.co.nextgenit.trucking.exception.InactiveEntityException;
import mz.co.nextgenit.trucking.exception.ResourceNotFoundExpection;
import mz.co.nextgenit.trucking.repository.CompanyClientRepository;
import mz.co.nextgenit.trucking.repository.RequestRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final CompanyClientRepository companyClientRepository;

    public Request getRequestById(UUID id) {
        return requestRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExpection("Request not found"));
    }

    public UUID save(RequestDto requestDto) throws Exception {

        CompanyClient client = companyClientRepository.findById(requestDto.companyClientId())
                .orElseThrow(() -> new Exception("Client not found"));

        if (!client.getStatus().equals(CompanyClient.CompanyClientStatus.ACTIVE.toString())) {
            throw new InactiveEntityException("Client is not active");
        }

        Request request = new Request();
        request.setStarting_point(requestDto.startingPoint());
        request.setEnding_point(requestDto.endingPoint());
        request.setCompany_client(client);
        request.setProposed_price(requestDto.proposedPrice());
        request.setWeight_kg(requestDto.weightKg());
        request.setVolume_m3(requestDto.volumeM3());

        requestRepository.save(request);

        return request.getId();
    }

}
