package mz.co.nextgenit.trucking.controller;

import lombok.RequiredArgsConstructor;
import mz.co.nextgenit.trucking.dto.RequestDto;
import mz.co.nextgenit.trucking.entity.Request;
import mz.co.nextgenit.trucking.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        Request request = requestService.getRequestById(id);
        return ResponseEntity.ok(request);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated RequestDto requestDto) throws Exception {

        UUID requestId = requestService.save(requestDto);

        return ResponseEntity.ok(requestId);
    }

}
